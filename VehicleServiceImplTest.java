package com.codetest.vis.testclient;
package com.accionlabs.codetest.vis.testclient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.codetest.vis.dao.VehicleDao;
import com.codetest.vis.exceptions.VehicleServiceException;
import com.codetest.vis.model.Vehicle;
import com.codetest.vis.model.VehicleType;
import com.codetest.vis.repositories.VehicleRepository;
import com.codetest.vis.service.VehicleInventorySearchServiceImpl;
import com.codetest.vis.service.VehicleServiceImpl;

public class VehicleServiceImplTest {

	@InjectMocks
	VehicleInventorySearchServiceImpl vehicleInventorySearchServiceImpl2;
	
	@InjectMocks
	VehicleServiceImpl vehicleInventorySearchServiceImpl;

	@Mock
	VehicleRepository vehicleRepository;
	@Mock
	VehicleDao vehicleDao;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllVehicles_returnsVehicleList() {
		// Setup
		List<Vehicle> vehicleList = new ArrayList<>();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleType("Airplane");
		vehicle1.setVehicleMake("Jet");

		vehicleList.add(vehicle);
		vehicleList.add(vehicle1);

		// Mock
		Mockito.when(vehicleRepository.findAll()).thenReturn(vehicleList);

		// Run
		List<Vehicle> allVehicles = vehicleInventorySearchServiceImpl.getAllVehicles();

		// Assert
		assertEquals(vehicleList, allVehicles);

	}

	@Test
	public void getAllVehicles_returnsEmptyList() {

		// Mock
		Mockito.when(vehicleRepository.findAll()).thenReturn(null);

		// Run
		List<Vehicle> allVehicles = vehicleInventorySearchServiceImpl.getAllVehicles();

		// Assert
		assertNull(allVehicles);
	}

	@Test
	public void getVehicle_returnsVehicle() {

		// Setup
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");
		vehicle.setVehicleId(1);

		// Mock
		Mockito.when(vehicleRepository.findOne(1)).thenReturn(vehicle);

		// Run
		Vehicle vehicleResponse = vehicleInventorySearchServiceImpl.getVehicle(1);

		// Assert
		assertEquals(vehicle, vehicleResponse);
	}

	@Test
	public void getVehicle_returnsNull() {

		// Mock
		Mockito.when(vehicleRepository.findOne(1)).thenReturn(null);

		// Run
		Vehicle vehicleResponse = vehicleInventorySearchServiceImpl.getVehicle(1);

		// Assert
		assertNull(vehicleResponse);
	}

	@Test(expected = VehicleServiceException.class)
	public void updateVehicle_shouldReturnsVehicleException() {

		// Setup
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleType("Car");
		vehicle.setVehicleMake("Honda");

		// Mock
		Mockito.when(vehicleRepository.findOne(anyInt())).thenReturn(null);

		// Run
		vehicleInventorySearchServiceImpl.updateVehicle(vehicle, 1);

	}

	@Test(expected = VehicleServiceException.class)
	public void deleteVehicle_shouldReturnsVehicleException() {

		// Mock
		Mockito.when(vehicleRepository.findOne(anyInt())).thenReturn(null);

		// Run
		vehicleInventorySearchServiceImpl.deleteLatestVehicle();

	}

}
