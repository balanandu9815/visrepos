# visrepos
Vehicle Inventory Search Restful application

1)     Vehicle could be of different types with specific properties and behaviors. Types: Car, Truck, Airplane, Drone, Amphibian, Boat.

2)     CRUD operations to manage vehicles

3)     Save to a local db like h2 or sqlite

4)     Ability to search for vehicles

4)     Delete recent API - should delete last added vehicle

VehicleInventorySearchController is rest Resource to use it
API Information

/* Operation:Create
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/createVehicle
	 * Request: xml or json in request body(see in sample.xml)
	 * Response: 200 Vehicle is Saved
	 */
   
   Sample:
   <?xml version="1.0" encoding="UTF-8"?>
<Vehicle>
	<VehicleName>Ashok Leyland</VehicleName>
	<VehicleId>001</VehicleId>
	<VehicleType>Bus</VehicleType>
	<VehicleYear>2018</VehicleYear>
	<VehicleMake>TATA</VehicleMake>
	<VehicleModel>TATA</VehicleModel>
	<VehiclePrice>778968.00</VehiclePrice>
	<VehicleSpeed>76</VehicleSpeed>
	<Vehicle_timestamp>2000-12-20 19:00:00</Vehicle_timestamp>
	<Description>AC bus, sleeper</Description>
	<Features>DVD Coach</Features>
	<RegisteredBy>balanand</RegisteredBy>
</Vehicle>

/*
	 * Operation:READ
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/getVehicle/1
	 * Request:pass id as path param
	 * Response: returns vehicle data based on Vechile Id
	 */
   
   /*
	 * Operation:UPDATE
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/putVehicle/1
	 * Request:pass id as path param
	 * Response: returns updated vehicle data based on Vechile id
	 */
   
   /*
	 * Operation:DELETE
	 * URL:http://localhost:8080/VehicleInventorySearch/rest/vis/deleteLastVehicle
	 * Request:
	 * Response: returns deleted recent vehicle status
	 */
