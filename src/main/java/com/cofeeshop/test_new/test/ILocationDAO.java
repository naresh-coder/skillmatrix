package com.test;

import java.util.List;

/**
 * Interface for LocationDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILocationDAO {
	/**
	 * Perform an initial save of a previously unsaved Location entity. All
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
	 * ILocationDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Location entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Location entity);

	/**
	 * Delete a persistent Location entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be permanently
	 * deleted from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILocationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Location entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Location entity);

	/**
	 * Persist a previously saved Location entity and return it or a copy of it to
	 * the sender. A copy of the Location entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ILocationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Location entity to update
	 * @return Location the persisted Location entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Location update(Location entity);

	public Location findById(Integer id);

	/**
	 * Find all Location entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Location property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Location> found by query
	 */
	public List<Location> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<Location> findByLocationName(Object locationName, int... rowStartIdxAndCount);

	public List<Location> findByPin(Object pin, int... rowStartIdxAndCount);

	/**
	 * Find all Location entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Location> all Location entities
	 */
	public List<Location> findAll(int... rowStartIdxAndCount);
}