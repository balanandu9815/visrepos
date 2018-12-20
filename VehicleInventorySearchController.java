/**
 * @author Balanandu Mettu
 *
 */

package com.codetest.vis.Controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;

import com.codetest.vis.exceptions.VehicleServiceException;
import com.codetest.vis.model.Vehicle;
import com.codetest.vis.model.VehicleXML;
import com.codetest.vis.service.VehicleInventorySearchService;
import com.codetest.vis.service.VehicleInventorySearchServiceImpl;
/*
 * This class is used Rest Resource for performing CRUD operations on Vechicle
 */
@Component
@Path("/vis")
public class VehicleInventorySearchController {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	//@Autowired
	VehicleInventorySearchService vehicleInventorySearchService = new VehicleInventorySearchServiceImpl();

	/*// setter for vehicleService
	public void setVehicleInventorySearchService(VehicleInventorySearchService vehicleService) {
		this.vehicleInventorySearchService = vehicleService;
	}*/

	/* Operation:Create
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/createVehicle
	 * Request: xml or json in request body(see in sample.xml)
	 * Response: 200 Vehicle is Saved
	 */
	@SuppressWarnings("unused")
	@POST
	@Path("createVehicle")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addVehicle(JAXBElement<VehicleXML> vehicleXml) {
		System.out.println("Start addVehicle: {} " + vehicleXml.getValue().toString());
		try {
			if (vehicleXml == null) {
				return Response.status(400).entity("No Valid Data").build();
			}
			Vehicle vehicle = new Vehicle(vehicleXml.getValue().getVehicleId(), vehicleXml.getValue().getVehicleName(),
					vehicleXml.getValue().getVehicleType(), vehicleXml.getValue().getVehicleYear(), vehicleXml.getValue().getVehicleMake(),
					vehicleXml.getValue().getVehicleModel(), vehicleXml.getValue().getVehiclePrice(), vehicleXml.getValue().getVehicleSpeed(),
					vehicleXml.getValue().getVehicle_timestamp(), vehicleXml.getValue().getDescription(), vehicleXml.getValue().getFeatures(),
					vehicleXml.getValue().getRegisteredBy());
			System.out.println("Vehicle: "+vehicle.toString());
			vehicleInventorySearchService.createVehicle(vehicle);
		} catch (VehicleServiceException ex) {
			System.out.println("Error in addVehicle(Vehicle vehicle) api, Error message is:  " + ex.getMessage());
			ex.printStackTrace();
		}
		return Response.status(200).entity("Vehicle is Saved ").build();
	}

	/*
	 * Operation:READ
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/getVehicle/1
	 * Request:pass id as path param
	 * Response: returns vehicle data based on Vechile Id
	 */
	@GET
	@Path("/getVehicle/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	//@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getVehicle(@PathParam("id") int id) {
		System.out.println("Start getVehicle: {}" + id);
		Vehicle vehicle = new Vehicle();
		try {
			vehicle = vehicleInventorySearchService.readVehicle(id);
			if (vehicle == null) {
				throw new VehicleServiceException("Vehicle with Id: " + id + "does not exist");
			}
		} catch (VehicleServiceException e) {
			System.out.println(" Error fetching vehicle.  Error message is: " + e.getMessage());
			return Response.status(404).entity("Vehicle is not Found for Given ID: " + id).build();
		} catch (Exception e) {
			System.out.println(" Error fetching vehicle.  Error message is: " + e.getMessage());
			return Response.status(500).entity("Vehicle is not Found for Given ID: " + id).build();
		}
		return Response.status(200).entity(vehicle).build();
	}
	/*
	 * Operation:UPDATE
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/putVehicle/1
	 * Request:pass id as path param
	 * Response: returns updated vehicle data based on Vechile id
	 */
	@PUT
	@Path("/putVehicle/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateVehicle(@PathParam("id") int id, Vehicle v) {
		System.out.println("Start updateVehicle: " + v.toString() + "with id: " + id);
		try {
			Vehicle vehicle = vehicleInventorySearchService.readVehicle(id);
			if (vehicle == null) {
				return Response.status(404).entity("Vehicle is not Found for Given ID: " + id).build();
			}
			vehicle = vehicleInventorySearchService.getVehicleDetails(vehicle);
			vehicleInventorySearchService.updateVehicle(vehicle);
			return Response.status(200).entity(vehicle).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" Error updating vehicle.  Error message is: " + ex.getMessage());
			return Response.status(500).entity("Error updating vehicles. ").build();
		}

	}
	/*
	 * Operation:READ
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/listVehicles
	 * Request:pass id as path param
	 * Response: returns deleted vehicle data 
	 */
	@GET
	@Path("/listVehicles")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response listAllVehicles() {
		System.out.println("Start listVehicles");
		List<Vehicle> vehicles;
		try {
			vehicles = vehicleInventorySearchService.getAllVehicles();
			if (vehicles.isEmpty()) {
				return Response.status(204).entity("Vehicles Details are Empty").build();
			}
			return Response.status(200).entity(vehicles).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" Error fetching vehicles.  Error message is: " + ex.getMessage());
			return Response.status(500).entity("Error fetching vehicles. ").build();
		}
	}
	/*
	 * Operation:DELETE
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/deleteLastVehicle
	 * Request:
	 * Response: returns deleted recent vehicle status
	 */
	@DELETE
	@Path("/deleteLastVehicle")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteLastAddedVehicle() {
		System.out.println("Start deleteLastAddedVehicle: ");
		try {
			Vehicle vehicle = vehicleInventorySearchService.getLastAddedVehicle();
			if (vehicle == null) {
				return Response.status(404).entity("Vehicle is not Found").build();
			}
			vehicleInventorySearchService.deleteVehicle(vehicle);
			return Response.status(200).entity(vehicle).build();
		} /*
			 * catch (VehicleServiceException ex1) {
			 * System.out.println(" Error deleting recent vehicle.  Error message is: " +
			 * ex1.getMessage()); return
			 * Response.status(204).entity("No Content Found or vehicle is deleted ").build(
			 * ); }
			 */catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" Error deleting recent vehicle.  Error message is: " + ex.getMessage());
			return Response.status(500).entity("Error deleting recent vehicles. ").build();
		}
	}
	/*
	 * Operation:DELETE
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/deleteVehicle/1
	 * Request:pass id as path param
	 * Response: returns deleted vehicle status 
	 */
	@DELETE
	@Path("/deleteVehicle/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteVehicle(@PathParam("id") int id) {
		System.out.println("Start deleteVehicle: " + id);
		try {
			Vehicle vehicle = vehicleInventorySearchService.readVehicle(id);
			if (vehicle == null) {
				return Response.status(204).entity("No Content Found or vehicle is deleted ").build();
			}
			vehicleInventorySearchService.deleteVehicle(vehicle);
			return Response.status(200).entity(vehicle).build();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" Error deleting vehicle.  Error message is: " + ex.getMessage());
			return Response.status(500).entity("Error deleting in vehicle. ").build();
		}
	}
	/*
	 * Operation:DELETE
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/deleteAllVehicles
	 * Request:
	 * Response: 200,All Vehicles are Deleted
	 */
	@DELETE
	@Path("/deleteAllVehicles")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response removeAllVehicles() {
		System.out.println("Start removeAllVehicles: ");
		try {

			vehicleInventorySearchService.deleteAllVehicles();
			return Response.status(200).entity("All Vehicles are Deleted").build();
			// return Response.status(204).entity("No Content Found or vehicle are deleted
			// ").build();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(" Error deleting vehicle.  Error message is: " + ex.getMessage());
			return Response.status(500).entity("Error deleting in vehicle. ").build();
		}
	}

}
