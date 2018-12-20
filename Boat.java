package com.codetest.vis.model;

public class Boat extends AbstractVehicle {

	@Override
	public double calculateVehiclePrice(String model) {

		double price;
		switch (model) {

		case "Cruise Liner":
			price = 12000;
			break;

		case "Wooden Boat":
			price = 11000;
			break;

		case "Chris Craft":
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
