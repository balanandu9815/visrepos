package com.codetest.vis.model;

public class Truck extends AbstractVehicle {

	@Override
	public double calculateVehiclePrice(String model) {

		double price;
		switch (model) {

		case "Chevrolet Silverado":
			price = 12000;
			break;

		case "GMC Canyon":
			price = 11000;
			break;

		case "Toyota Tundra":
			price = 13000;
			break;

		case "Honda Ridgeline":
			price = 10500;
			break;

		default:
			price = 0.0;
		}

		return price;
	}

	@Override
	public int calculateVehicleSpeed(String model) {
		int speed;

		switch (model) {
		case "Chevrolet Silverado":
			speed = 70;
			break;

		case "GMC Canyon":
			speed = 80;
			break;

		case "Toyota Tundra":
			speed = 75;
			break;

		case "Honda Ridgeline":
			speed = 68;
			break;

		default:
			speed = 0;
		}
		return speed;
	}

}
