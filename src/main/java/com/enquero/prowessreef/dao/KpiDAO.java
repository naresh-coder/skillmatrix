package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.Kpi;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Kpi
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see Kpi
 * @author MyEclipse Persistence Tools
 */
public class KpiDAO implements IKpiDAO {
	// property constants
	public static final String EMPLOYEE_TARGET = "employeeTarget";
	public static final String RECHEAD_TARGET = "recheadTarget";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Kpi entity. All subsequent
	 * persist actions of this entity should use the #update() method. This
	 * operation must be performed within the a database transaction context for the
	 * entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * 
	 * EntityManagerHelper.beginTransaction();
	 * KpiDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Kpi entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Kpi entity) {
		EntityManagerHelper.log("saving Kpi instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Kpi entity. This operation must be performed within the a
	 * database transaction context for the entity's data to be permanently deleted
	 * from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * KpiDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Kpi entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Kpi entity) {
		EntityManagerHelper.log("deleting Kpi instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Kpi.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Kpi entity and return it or a copy of it to the
	 * sender. A copy of the Kpi entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = KpiDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Kpi entity to update
	 * @return Kpi the persisted Kpi entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Kpi update(Kpi entity) {
		EntityManagerHelper.log("updating Kpi instance", Level.INFO, null);
		try {
			Kpi result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Kpi findById(Integer id) {
		EntityManagerHelper.log("finding Kpi instance with id: " + id, Level.INFO, null);
		try {
			Kpi instance = getEntityManager().find(Kpi.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Kpi entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Kpi property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            number of results to return.
	 * @return List<Kpi> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Kpi> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Kpi instance with property: " + propertyName + ", value: " + value, Level.INFO,
				null);
		try {
			final String queryString = "select model from Kpi model where model." + propertyName + "= :propertyValue";
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

	public List<Kpi> findByEmployeeTarget(Object employeeTarget, int... rowStartIdxAndCount) {
		return findByProperty(EMPLOYEE_TARGET, employeeTarget, rowStartIdxAndCount);
	}

	public List<Kpi> findByRecheadTarget(Object recheadTarget, int... rowStartIdxAndCount) {
		return findByProperty(RECHEAD_TARGET, recheadTarget, rowStartIdxAndCount);
	}

	/**
	 * Find all Kpi entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Kpi> all Kpi entities
	 */
	@SuppressWarnings("unchecked")
	public List<Kpi> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Kpi instances", Level.INFO, null);
		try {
			final String queryString = "select model from Kpi model";
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