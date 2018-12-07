package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.DesignationMatrix;

import java.util.List;

/**
 * Interface for DesignationMatrixDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IDesignationMatrixDAO {
	/**
	 * Perform an initial save of a previously unsaved DesignationMatrix entity. All
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
	 * IDesignationMatrixDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity DesignationMatrix entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(DesignationMatrix entity);

	/**
	 * Delete a persistent DesignationMatrix entity. This operation must be
	 * performed within the a database transaction context for the entity's data to
	 * be permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IDesignationMatrixDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity DesignationMatrix entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(DesignationMatrix entity);

	/**
	 * Persist a previously saved DesignationMatrix entity and return it or a copy
	 * of it to the sender. A copy of the DesignationMatrix entity parameter is
	 * returned when the JPA persistence mechanism has not previously been tracking
	 * the updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IDesignationMatrixDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity DesignationMatrix entity to update
	 * @return DesignationMatrix the persisted DesignationMatrix entity instance,
	 *         may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public DesignationMatrix update(DesignationMatrix entity);

	public DesignationMatrix findById(Integer id);

	/**
	 * Find all DesignationMatrix entities with a specific property value.
	 * 
	 * @param propertyName        the name of the DesignationMatrix property to
	 *                            query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<DesignationMatrix> found by query
	 */
	public List<DesignationMatrix> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	/**
	 * Find all DesignationMatrix entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<DesignationMatrix> all DesignationMatrix entities
	 */
	public List<DesignationMatrix> findAll(int... rowStartIdxAndCount);
}