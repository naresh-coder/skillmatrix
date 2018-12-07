package com.test;

import java.util.List;

/**
 * Interface for DesignationTypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IDesignationTypeDAO {
	/**
	 * Perform an initial save of a previously unsaved DesignationType entity. All
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
	 * IDesignationTypeDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity DesignationType entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(DesignationType entity);

	/**
	 * Delete a persistent DesignationType entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This method
	 * uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IDesignationTypeDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity DesignationType entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(DesignationType entity);

	/**
	 * Persist a previously saved DesignationType entity and return it or a copy of
	 * it to the sender. A copy of the DesignationType entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IDesignationTypeDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity DesignationType entity to update
	 * @return DesignationType the persisted DesignationType entity instance, may
	 *         not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public DesignationType update(DesignationType entity);

	public DesignationType findById(Integer id);

	/**
	 * Find all DesignationType entities with a specific property value.
	 * 
	 * @param propertyName        the name of the DesignationType property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<DesignationType> found by query
	 */
	public List<DesignationType> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<DesignationType> findByDesignationName(Object designationName, int... rowStartIdxAndCount);

	/**
	 * Find all DesignationType entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<DesignationType> all DesignationType entities
	 */
	public List<DesignationType> findAll(int... rowStartIdxAndCount);
}