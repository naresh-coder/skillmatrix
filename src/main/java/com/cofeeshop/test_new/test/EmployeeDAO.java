package com.test;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Employee entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.test.Employee
 * @author MyEclipse Persistence Tools
 */
public class EmployeeDAO implements IEmployeeDAO {
	// property constants
	public static final String NAME = "name";
	public static final String EMAIL_ID = "emailId";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String FLAG = "flag";
	public static final String GENDER = "gender";
	public static final String CREATED_BY = "createdBy";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Employee entity. All
	 * subsequent persist actions of this entity should use the #update() method.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * 
	 * EntityManagerHelper.beginTransaction();
	 * EmployeeDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Employee entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Employee entity) {
		EntityManagerHelper.log("saving Employee instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Employee entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be permanently
	 * deleted from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EmployeeDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Employee entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Employee entity) {
		EntityManagerHelper.log("deleting Employee instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Employee.class, entity.getEmployeeId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Employee entity and return it or a copy of it to
	 * the sender. A copy of the Employee entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = EmployeeDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Employee entity to update
	 * @return Employee the persisted Employee entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Employee update(Employee entity) {
		EntityManagerHelper.log("updating Employee instance", Level.INFO, null);
		try {
			Employee result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Employee findById(Integer id) {
		EntityManagerHelper.log("finding Employee instance with id: " + id, Level.INFO, null);
		try {
			Employee instance = getEntityManager().find(Employee.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Employee entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Employee property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            number of results to return.
	 * @return List<Employee> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Employee instance with property: " + propertyName + ", value: " + value,
				Level.INFO, null);
		try {
			final String queryString = "select model from Employee model where model." + propertyName
					+ "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	public List<Employee> findByName(Object name, int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<Employee> findByEmailId(Object emailId, int... rowStartIdxAndCount) {
		return findByProperty(EMAIL_ID, emailId, rowStartIdxAndCount);
	}

	public List<Employee> findByPhoneNumber(Object phoneNumber, int... rowStartIdxAndCount) {
		return findByProperty(PHONE_NUMBER, phoneNumber, rowStartIdxAndCount);
	}

	public List<Employee> findByFlag(Object flag, int... rowStartIdxAndCount) {
		return findByProperty(FLAG, flag, rowStartIdxAndCount);
	}

	public List<Employee> findByGender(Object gender, int... rowStartIdxAndCount) {
		return findByProperty(GENDER, gender, rowStartIdxAndCount);
	}

	public List<Employee> findByCreatedBy(Object createdBy, int... rowStartIdxAndCount) {
		return findByProperty(CREATED_BY, createdBy, rowStartIdxAndCount);
	}

	/**
	 * Find all Employee entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Employee> all Employee entities
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Employee instances", Level.INFO, null);
		try {
			final String queryString = "select model from Employee model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}