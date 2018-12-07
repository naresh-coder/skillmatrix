package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.Account;

import java.util.List;

/**
 * Interface for AccountDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IAccountDAO {
	/**
	 * Perform an initial save of a previously unsaved Account entity. All
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
	 * IAccountDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Account entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Account entity);

	/**
	 * Delete a persistent Account entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be permanently
	 * deleted from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAccountDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Account entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Account entity);

	/**
	 * Persist a previously saved Account entity and return it or a copy of it to
	 * the sender. A copy of the Account entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IAccountDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Account entity to update
	 * @return Account the persisted Account entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Account update(Account entity);

	public Account findById(Integer id);

	/**
	 * Find all Account entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Account property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Account> found by query
	 */
	public List<Account> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<Account> findByEmployeeId(Object employeeId, int... rowStartIdxAndCount);

	public List<Account> findByRoleId(Object roleId, int... rowStartIdxAndCount);

	/**
	 * Find all Account entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Account> all Account entities
	 */
	public List<Account> findAll(int... rowStartIdxAndCount);
}