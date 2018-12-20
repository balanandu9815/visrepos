package com.codetest.vis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.codetest.vis.model.Vehicle;
/*
 * This class makes use of entity manager class for crud operations using h2 database mentioned in persistennce.xml
 * 
 */
public class VehicleDaoImpl implements VehicleDao {

	@PersistenceContext(unitName="persistenceUnit")
	private EntityManager eManager;
	private EntityManagerFactory entityManagerFactory;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");//gets Persistence
		eManager = entityManagerFactory.createEntityManager();
		return eManager;
	}

	@Override
	public void saveVehicleObject(Object visObj) {
		eManager.persist(visObj);
	}

	@Override
	public void beginTransaction() {
		if (null == eManager) {
			eManager = getEntityManager();
		} else {
			eManager = entityManagerFactory.createEntityManager();
		}
		eManager.getTransaction().begin();
	}

	@Override
	public void closeConnection() {
		eManager.close();
	}

	@Override
	public void commitTransaction() {
		eManager.getTransaction().commit();
	}

	@Override
	public void rollbackTransaction() {
		EntityTransaction entityTxn = eManager.getTransaction();
		if (entityTxn.isActive())
			entityTxn.rollback();
	}

	@Override
	public Object readVehicleObject(Class<?> cls, int id) {
		return eManager.find(cls, id);
	}

	@Override
	public void deleteVehicleObject(Object obj) {
		eManager.remove(obj);
	}

	@Override
	public void updateVehicleObject(Object obj) {
		eManager.merge(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> fetchVehicleList(String query) {
		return eManager.createQuery(query).getResultList();
	}

	@Override
	@Transactional
	public void deleteVehicleById(String query) {
		eManager.createQuery(query).executeUpdate();
	}

}
