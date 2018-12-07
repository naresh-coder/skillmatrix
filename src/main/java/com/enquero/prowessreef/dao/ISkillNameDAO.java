package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.SkillName;

import java.util.List;

/**
 * Interface for SkillNameDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISkillNameDAO {
	/**
	 * Perform an initial save of a previously unsaved SkillName entity. All
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
	 * ISkillNameDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillName entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(SkillName entity);

	/**
	 * Delete a persistent SkillName entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be permanently
	 * deleted from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISkillNameDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity SkillName entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(SkillName entity);

	/**
	 * Persist a previously saved SkillName entity and return it or a copy of it to
	 * the sender. A copy of the SkillName entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISkillNameDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity SkillName entity to update
	 * @return SkillName the persisted SkillName entity instance, may not be the
	 *         same
	 * @throws RuntimeException if the operation fails
	 */
	public SkillName update(SkillName entity);

	public SkillName findById(Integer id);

	/**
	 * Find all SkillName entities with a specific property value.
	 * 
	 * @param propertyName        the name of the SkillName property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<SkillName> found by query
	 */
	public List<SkillName> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<SkillName> findByName(Object name, int... rowStartIdxAndCount);

	/**
	 * Find all SkillName entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<SkillName> all SkillName entities
	 */
	public List<SkillName> findAll(int... rowStartIdxAndCount);
}