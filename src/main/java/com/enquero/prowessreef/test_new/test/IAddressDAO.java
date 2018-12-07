package com.test;

import java.util.List;

/**
 * Interface for AddressDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IAddressDAO {
	/**
	 * Perform an initial save of a previously unsaved Address entity. All
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
	 * IAddressDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Address entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Address entity);

	/**
	 * Delete a persistent Address entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be permanently
	 * deleted from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAddressDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Address entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Address entity);

	/**
	 * Persist a previously saved Address entity and return it or a copy of it to
	 * the sender. A copy of the Address entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IAddressDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Address entity to update
	 * @return Address the persisted Address entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Address update(Address entity);

	public Address findById(Integer id);

	/**
	 * Find all Address entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Address property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Address> found by query
	 */
	public List<Address> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<Address> findByAddressName(Object addressName, int... rowStartIdxAndCount);

	public List<Address> findByLandMark(Object landMark, int... rowStartIdxAndCount);

	public List<Address> findByCity(Object city, int... rowStartIdxAndCount);

	public List<Address> findByState(Object state, int... rowStartIdxAndCount);

	public List<Address> findByCountry(Object country, int... rowStartIdxAndCount);

	/**
	 * Find all Address entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Address> all Address entities
	 */
	public List<Address> findAll(int... rowStartIdxAndCount);
}