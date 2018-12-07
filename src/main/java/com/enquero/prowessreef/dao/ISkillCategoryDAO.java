package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.SkillCategory;

import java.util.List;

/**
 * Interface for SkillCategoryDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISkillCategoryDAO {
	/**
	 * Perform an initial save of a previously unsaved SkillCategory entity. All
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
	 * ISkillCategoryDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillCategory entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(SkillCategory entity);

	/**
	 * Delete a persistent SkillCategory entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This method
	 * uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISkillCategoryDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity SkillCategory entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(SkillCategory entity);

	/**
	 * Persist a previously saved SkillCategory entity and return it or a copy of it
	 * to the sender. A copy of the SkillCategory entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database transaction
	 * context for the entity's data to be permanently saved to the persistence
	 * store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISkillCategoryDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillCategory entity to update
	 * @return SkillCategory the persisted SkillCategory entity instance, may not be
	 *         the same
	 * @throws RuntimeException if the operation fails
	 */
	public SkillCategory update(SkillCategory entity);

	public SkillCategory findById(Integer id);

	/**
	 * Find all SkillCategory entities with a specific property value.
	 * 
	 * @param propertyName        the name of the SkillCategory property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<SkillCategory> found by query
	 */
	public List<SkillCategory> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<SkillCategory> findBySkillCategoryName(Object skillCategoryName, int... rowStartIdxAndCount);

	/**
	 * Find all SkillCategory entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<SkillCategory> all SkillCategory entities
	 */
	public List<SkillCategory> findAll(int... rowStartIdxAndCount);
}