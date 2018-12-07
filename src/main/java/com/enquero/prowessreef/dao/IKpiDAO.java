package com.enquero.prowessreef.dao;

import com.enquero.prowessreef.model.Kpi;

import java.util.List;

/**
 * Interface for KpiDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IKpiDAO {
	/**
	 * Perform an initial save of a previously unsaved Kpi entity. All subsequent
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
	 * IKpiDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Kpi entity to persist
	 * @throws RuntimeException when the operation fails
	 */
	public void save(Kpi entity);

	/**
	 * Delete a persistent Kpi entity. This operation must be performed within the a
	 * database transaction context for the entity's data to be permanently deleted
	 * from the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IKpiDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity Kpi entity to delete
	 * @throws RuntimeException when the operation fails
	 */
	public void delete(Kpi entity);

	/**
	 * Persist a previously saved Kpi entity and return it or a copy of it to the
	 * sender. A copy of the Kpi entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated entity.
	 * This operation must be performed within the a database transaction context
	 * for the entity's data to be permanently saved to the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IKpiDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity Kpi entity to update
	 * @return Kpi the persisted Kpi entity instance, may not be the same
	 * @throws RuntimeException if the operation fails
	 */
	public Kpi update(Kpi entity);

	public Kpi findById(Integer id);

	/**
	 * Find all Kpi entities with a specific property value.
	 * 
	 * @param propertyName        the name of the Kpi property to query
	 * @param value               the property value to match
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Kpi> found by query
	 */
	public List<Kpi> findByProperty(String propertyName, Object value, int... rowStartIdxAndCount);

	public List<Kpi> findByEmployeeTarget(Object employeeTarget, int... rowStartIdxAndCount);

	public List<Kpi> findByRecheadTarget(Object recheadTarget, int... rowStartIdxAndCount);

	/**
	 * Find all Kpi entities.
	 * 
	 * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0]
	 *                            specifies the the row index in the query
	 *                            result-set to begin collecting the results.
	 *                            rowStartIdxAndCount[1] specifies the the maximum
	 *                            count of results to return.
	 * @return List<Kpi> all Kpi entities
	 */
	public List<Kpi> findAll(int... rowStartIdxAndCount);
}