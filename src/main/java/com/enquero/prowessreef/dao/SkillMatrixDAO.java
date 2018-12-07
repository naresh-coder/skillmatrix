package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.SkillMatrix;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * SkillMatrix entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see SkillMatrix
 * @author MyEclipse Persistence Tools
 */
public class SkillMatrixDAO implements ISkillMatrixDAO {
	// property constants
	public static final String NO_OF_YEARS = "noOfYears";
	public static final String IS_CERTIFIED = "isCertified";
	public static final String NAME_OF_INSTITUTE = "nameOfInstitute";
	public static final String SCORE = "score";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved SkillMatrix entity. All
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
	 * SkillMatrixDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillMatrix entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(SkillMatrix entity) {
		EntityManagerHelper.log("saving SkillMatrix instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent SkillMatrix entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This method
	 * uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * SkillMatrixDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity SkillMatrix entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(SkillMatrix entity) {
		EntityManagerHelper.log("deleting SkillMatrix instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(SkillMatrix.class, entity.getSkillMatrixId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved SkillMatrix entity and return it or a copy of it
	 * to the sender. A copy of the SkillMatrix entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database transaction
	 * context for the entity's data to be permanently saved to the persistence
	 * store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = SkillMatrixDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillMatrix entity to update
	 * @return SkillMatrix the persisted SkillMatrix entity instance, may not be the
	 *         same
	 * @throws RuntimeException if the operation fails
	 */
	public SkillMatrix update(SkillMatrix entity) {
		EntityManagerHelper.log("updating SkillMatrix instance", Level.INFO, null);
		try {
			SkillMatrix result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public SkillMatrix findById(Integer id) {
		EntityManagerHelper.log("finding SkillMatrix instance with id: " + id, Level.INFO, null);
		try {
			SkillMatrix instance = getEntityManager().find(SkillMatrix.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all SkillMatrix entities with a specific property value.
	 * 
	 * @param propertyName        the name of the SkillMatrix property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            number of results to return.
	 * @return List<SkillMatrix> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<SkillMatrix> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding SkillMatrix instance with property: " + propertyName + ", value: " + value,
				Level.INFO, null);
		try {
			final String queryString = "select model from SkillMatrix model where model." + propertyName
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

	public List<SkillMatrix> findByNoOfYears(Object noOfYears, int... rowStartIdxAndCount) {
		return findByProperty(NO_OF_YEARS, noOfYears, rowStartIdxAndCount);
	}

	public List<SkillMatrix> findByIsCertified(Object isCertified, int... rowStartIdxAndCount) {
		return findByProperty(IS_CERTIFIED, isCertified, rowStartIdxAndCount);
	}

	public List<SkillMatrix> findByNameOfInstitute(Object nameOfInstitute, int... rowStartIdxAndCount) {
		return findByProperty(NAME_OF_INSTITUTE, nameOfInstitute, rowStartIdxAndCount);
	}

	public List<SkillMatrix> findByScore(Object score, int... rowStartIdxAndCount) {
		return findByProperty(SCORE, score, rowStartIdxAndCount);
	}

	/**
	 * Find all SkillMatrix entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<SkillMatrix> all SkillMatrix entities
	 */
	@SuppressWarnings("unchecked")
	public List<SkillMatrix> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all SkillMatrix instances", Level.INFO, null);
		try {
			final String queryString = "select model from SkillMatrix model";
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