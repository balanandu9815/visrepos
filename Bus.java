package com.codetest.vis.model;

public class Bus extends AbstractVehicle {

	@Override
	public double calculateVehiclePrice(String model) {

		double price;
		switch (model) {

		case "BENZ":
			price = 121000;
			break;

		case "TATA":
			price = 111000;
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
