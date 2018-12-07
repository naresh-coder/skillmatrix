package com.test;

import java.util.List;

/**
 * Interface for PermissionsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPermissionsDAO {
	/**
	 * Perform an initial save of a previously unsaved Permissions entity. All
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
	 * IPermissionsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Permissions entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Permissions entity);

	/**
	 * Delete a persistent Permissions entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This method
	 * uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPermissionsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Permissions entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Permissions entity);

	/**
	 * Persist a previously saved Permissions entity and return it or a copy of it
	 * to the sender. A copy of the Permissions entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database transaction
	 * context for the entity's data to be permanently saved to the persistence
	 * store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPermissionsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Permissions entity to update
	 * @return Permissions the persisted Permissions entity instance, may not be the
	 *         same
	 * @throws RuntimeException if the operation fails
	 */
	public Permissions update(Permissions entity);

	public Permissions findById(Integer id);

	/**
	 * Find all Permissions entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Permissions property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Permissions> found by query
	 */
	public List<Permissions> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<Permissions> findByPermissitionName(Object permissitionName, int... rowStartIdxAndCount);

	/**
	 * Find all Permissions entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Permissions> all Permissions entities
	 */
	public List<Permissions> findAll(int... rowStartIdxAndCount);
}