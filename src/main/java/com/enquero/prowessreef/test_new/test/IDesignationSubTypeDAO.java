package com.test;

import java.util.List;
import java.util.Set;

/**
 * Interface for DesignationSubTypeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IDesignationSubTypeDAO {
	/**
	 * Perform an initial save of a previously unsaved DesignationSubType entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database transaction
	 * context for the entity's data to be permanently saved to the persistence
	 * store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * 
	 * EntityManagerHelper.beginTransaction();
	 * IDesignationSubTypeDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity DesignationSubType entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(DesignationSubType entity);

	/**
	 * Delete a persistent DesignationSubType entity. This operation must be
	 * performed within the a database transaction context for the entity's data to
	 * be permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IDesignationSubTypeDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity DesignationSubType entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(DesignationSubType entity);

	/**
	 * Persist a previously saved DesignationSubType entity and return it or a copy
	 * of it to the sender. A copy of the DesignationSubType entity parameter is
	 * returned when the JPA persistence mechanism has not previously been tracking
	 * the updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IDesignationSubTypeDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity DesignationSubType entity to update
	 * @return DesignationSubType the persisted DesignationSubType entity instance,
	 *         may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public DesignationSubType update(DesignationSubType entity);

	public DesignationSubType findById(Integer id);

	/**
	 * Find all DesignationSubType entities with a specific property value.
	 * 
	 * @param propertyName        the name of the DesignationSubType property to
	 *                            query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<DesignationSubType> found by query
	 */
	public List<DesignationSubType> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<DesignationSubType> findBySubTypeName(Object subTypeName, int... rowStartIdxAndCount);

	/**
	 * Find all DesignationSubType entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<DesignationSubType> all DesignationSubType entities
	 */
	public List<DesignationSubType> findAll(int... rowStartIdxAndCount);
}