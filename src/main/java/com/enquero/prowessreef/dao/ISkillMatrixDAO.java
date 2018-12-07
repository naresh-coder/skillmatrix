package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.SkillMatrix;

import java.util.List;

/**
 * Interface for SkillMatrixDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISkillMatrixDAO {
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
	 * ISkillMatrixDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillMatrix entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(SkillMatrix entity);

	/**
	 * Delete a persistent SkillMatrix entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This method
	 * uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISkillMatrixDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity SkillMatrix entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(SkillMatrix entity);

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
	 * entity = ISkillMatrixDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillMatrix entity to update
	 * @return SkillMatrix the persisted SkillMatrix entity instance, may not be the
	 *         same
	 * @throws RuntimeException if the operation fails
	 */
	public SkillMatrix update(SkillMatrix entity);

	public SkillMatrix findById(Integer id);

	/**
	 * Find all SkillMatrix entities with a specific property value.
	 * 
	 * @param propertyName        the name of the SkillMatrix property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<SkillMatrix> found by query
	 */
	public List<SkillMatrix> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<SkillMatrix> findByNoOfYears(Object noOfYears, int... rowStartIdxAndCount);

	public List<SkillMatrix> findByIsCertified(Object isCertified, int... rowStartIdxAndCount);

	public List<SkillMatrix> findByNameOfInstitute(Object nameOfInstitute, int... rowStartIdxAndCount);

	public List<SkillMatrix> findByScore(Object score, int... rowStartIdxAndCount);

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
	public List<SkillMatrix> findAll(int... rowStartIdxAndCount);
}