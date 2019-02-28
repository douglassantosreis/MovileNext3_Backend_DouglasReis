package com.dgssr.findrestaurants.domain;

import java.io.Serializable;

import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputException;

public class InputSearch implements Serializable, Input {

	private static final long serialVersionUID = 2067014375291301982L;

	private Integer restaurantId;
	private double latitude;
	private double longitude;
	private double maxKilometers;

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getMaxKilometers() {
		return maxKilometers;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	@Override
	public void checkIfICanContinueUseSearch() {
		if (latitude == 0 || longitude == 0 || maxKilometers == 0) {
			throw new InvalidInputException("Alguns desses parameteros não foram encontrados " + "LATITUDE: "
					+ latitude + " LONGITUDE: " + longitude + " MAXKILOMETERS: " + maxKilometers);
		}

	}

	public static class InputSearchBuilder {
		private Integer restaurantId;
		private double latitude;
		private double longitude;
		private double maxKilometers;

		public InputSearchBuilder addRestaurantId(Integer restaurantId) {
			if(restaurantId == null) {
				throw new InvalidInputException("Informe o id do restaurante");
			}
			this.restaurantId = restaurantId;
			return this;
		}

		public InputSearchBuilder addLatitude(double latitude) {
			this.latitude = latitude;
			return this;
		}

		public InputSearchBuilder addLongitude(double longitude) {
			this.longitude = longitude;
			return this;
		}

		public InputSearchBuilder addMaxKilometers(double maxKilometers) {
			this.maxKilometers = maxKilometers;
			return this;
		}

		public InputSearch build() {
			InputSearch order = new InputSearch();
			order.restaurantId = this.restaurantId;
			order.latitude = this.latitude;
			order.longitude = this.longitude;
			order.maxKilometers = this.maxKilometers;
			order.checkIfICanContinueUseSearch();
			return order;
		}

	}

}
