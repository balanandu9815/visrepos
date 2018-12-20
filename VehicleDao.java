/**
 * @author Balanandu Mettu
 *
 */

package com.codetest.vis.dao;

import java.util.List;

import com.codetest.vis.model.Vehicle;

public interface VehicleDao {
	public void saveVehicleObject(Object visObj);

	public void beginTransaction();

	public void closeConnection();

	public void commitTransaction();

	public void rollbackTransaction();

	public Object readVehicleObject(Class<?> cls, int id);

	public void deleteVehicleObject(Object obj);

	public void updateVehicleObject(Object obj);

	public List<Vehicle> fetchVehicleList(String query);

	public void deleteVehicleById(String query);

}
