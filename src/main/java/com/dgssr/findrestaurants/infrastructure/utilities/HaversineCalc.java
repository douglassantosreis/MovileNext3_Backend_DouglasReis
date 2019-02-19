package com.dgssr.findrestaurants.infrastructure.utilities;

public class HaversineCalc {
	private final int EARTH_RADIUS = 6371;

	private double startLat;
	private double startLong;
	private double endLat;
	private double endLong;

	public HaversineCalc() {
		super();
	}

	public HaversineCalc(double startLat, double startLong, double endLat, double endLong) {
		this.startLat = startLat;
		this.startLong = startLong;
		this.endLat = endLat;
		this.endLong = endLong;
	}

	public double distance() {

		double dLat = Math.toRadians((this.endLat - this.startLat));
		double dLong = Math.toRadians((this.endLong - this.startLong));

		this.startLat = Math.toRadians(this.startLat);
		this.endLat = Math.toRadians(this.endLat);

		double a = haversin(dLat) + Math.cos(this.startLat) * Math.cos(this.endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c;
	}

	public static double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}
}
