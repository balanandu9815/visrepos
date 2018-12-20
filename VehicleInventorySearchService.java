/**
 * @author Balanandu Mettu
 *
 */
package com.codetest.vis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codetest.vis.exceptions.VehicleServiceException;
import com.codetest.vis.model.Vehicle;

@Service
public interface VehicleInventorySearchService {
	
	public static final String FETCH_ALL_VEHICLES="FROM Vehicle";
	public static final String FETCH_RECENT_VEHICLE="FROM Vehicle ORDER BY vehicleId DESC";
	public static final String DELETE_ALL_VEHICLE="DELETE FROM Vehicle";
	public static final String DELETE_RECENT_VEHICLE="DELETE FROM Vehicle WHERE vehicleId=:id";
	
	void createVehicle(Vehicle v)  throws VehicleServiceException;

	Vehicle readVehicle(int id);

	void updateVehicle(Vehicle v) ;

	void deleteVehicle(Vehicle v);

	List<Vehicle> getAllVehicles();

	void deleteAllVehicles();

	Vehicle getVehicleDetails(Vehicle v);

	public Vehicle getLastAddedVehicle();
}
