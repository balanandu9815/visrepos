/**
 * @author Balanandu Mettu
 *
 */
package com.codetest.vis.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Vehicle")
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
	private int vehicleId;
	@Column(name = "vehicle_name")
	private String vehicleName;
	@Column(name = "vehicle_type")
	private String vehicleType;// Car, Truck, Airplane, Drone, Amphibian, Boat
	@Column(name = "vehicle_year")
	private int vehicleYear;//manufacture year
	@Column(name = "vehicle_make")
	private String vehicleMake;//manufacturer name
	@Column(name = "vehicle_model")
	private String vehicleModel;//vehicle model
	@Column(name = "vehicle_price")
	private BigDecimal vehiclePrice;//price of the vehicle
	@Column(name = "vehicle_speed")
	private int vehicleSpeed;//speed of the vehicle
	@Column(name = "vehicle_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date vehicle_timestamp;//vehicle registered or inserted timestamp
	@Column(name = "description")
	private String description;
	@Column(name = "features")
	private String features;
	@Column(name = "registeredBy")
	private String registeredBy;
	
	@PrePersist
    public void onPreInsert(){
		vehicle_timestamp = new Timestamp(System.currentTimeMillis());
        registeredBy = "system";  
	}
	public Vehicle(){
	}

	public Vehicle(int vehicleId, String vehicleName, String vehicleType, int vehicleYear, String vehicleMake,
			String vehicleModel, BigDecimal vehiclePrice, int vehicleSpeed, Date date,
			String description, String features, String registeredBy) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleYear = vehicleYear;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehiclePrice = vehiclePrice;
		this.vehicleSpeed = vehicleSpeed;
		this.vehicle_timestamp = date;
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
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleType=" + vehicleType
				+ ", vehicleYear=" + vehicleYear + ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel
				+ ", vehiclePrice=" + vehiclePrice + ", vehicleSpeed=" + vehicleSpeed + ", vehicle_timestamp="
				+ vehicle_timestamp + ", description=" + description + ", features=" + features + ", registeredBy="
				+ registeredBy + "]";
	}

}
