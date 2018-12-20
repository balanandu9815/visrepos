/**
 * @author Balanandu Mettu
 *
 */
package com.codetest.vis.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Vehicle")
public class VehicleXML {

	@XmlElement(name="VehicleId")
	private int vehicleId;
	@XmlElement(name="VehicleName",required = true)
	private String vehicleName;
	@XmlElement(name="VehicleType",required = true)
	private String vehicleType;// Car, Truck, Airplane, Drone, Amphibian, Boat
	@XmlElement(name="VehicleYear",required = true)
	private int vehicleYear;// manufacture year
	@XmlElement(name="VehicleMake",required = true)
	private String vehicleMake;// manufacturer name
	@XmlElement(name="VehicleModel",required = true)
	private String vehicleModel;// vehicle model
	@XmlElement(name="VehiclePrice")
	private BigDecimal vehiclePrice;// price of the vehicle
	@XmlElement(name="VehicleSpeed")
	private int vehicleSpeed;// speed of the vehicle
	@XmlElement(name="Vehicle_timestamp")
	private Date vehicle_timestamp;// vehicle registered or inserted timestamp
	@XmlElement(name="Description")
	private String description;
	@XmlElement(name="Features")
	private String features;
	@XmlElement(name="RegisteredBy")
	private String registeredBy;
	
	public VehicleXML() {
		
	}

	public VehicleXML(int vehicleId, String vehicleName, String vehicleType, int vehicleYear, String vehicleMake,
			String vehicleModel, BigDecimal vehiclePrice, int vehicleSpeed, Date vehicle_timestamp, String description,
			String features, String registeredBy) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleYear = vehicleYear;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehiclePrice = vehiclePrice;
		this.vehicleSpeed = vehicleSpeed;
		this.vehicle_timestamp = vehicle_timestamp;
		this.description = description;
		this.features = features;
		this.registeredBy = registeredBy;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(int vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public BigDecimal getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(BigDecimal vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public int getVehicleSpeed() {
		return vehicleSpeed;
	}

	public void setVehicleSpeed(int vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}

	public Date getVehicle_timestamp() {
		return vehicle_timestamp;
	}

	public void setVehicle_timestamp(Timestamp vehicle_timestamp) {
		this.vehicle_timestamp = vehicle_timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getRegisteredBy() {
		return registeredBy;
	}

	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}

	public void setVehicle_timestamp(Date vehicle_timestamp) {
		this.vehicle_timestamp = vehicle_timestamp;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", vehicleYear=" + vehicleYear + ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel
				+ ", vehiclePrice=" + vehiclePrice + ", vehicleSpeed=" + vehicleSpeed + ", vehicle_timestamp="
				+ vehicle_timestamp + ", description=" + description + ", features=" + features + ", registeredBy="
				+ registeredBy + "]";
	}

}
