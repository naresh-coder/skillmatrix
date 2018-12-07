package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.Roles;

import java.util.List;

/**
 * Interface for RolesDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IRolesDAO {
	/**
	 * Perform an initial save of a previously unsaved Roles entity. All subsequent
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
	 * IRolesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Roles entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Roles entity);

	/**
	 * Delete a persistent Roles entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * deleted from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IRolesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Roles entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Roles entity);

	/**
	 * Persist a previously saved Roles entity and return it or a copy of it to the
	 * sender. A copy of the Roles entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IRolesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Roles entity to update
	 * @return Roles the persisted Roles entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Roles update(Roles entity);

	public Roles findById(Integer id);

	/**
	 * Find all Roles entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Roles property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Roles> found by query
	 */
	public List<Roles> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<Roles> findByRoleName(Object roleName, int... rowStartIdxAndCount);

	public List<Roles> findByPermissonId(Object permissonId, int... rowStartIdxAndCount);

	/**
	 * Find all Roles entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Roles> all Roles entities
	 */
	public List<Roles> findAll(int... rowStartIdxAndCount);
}