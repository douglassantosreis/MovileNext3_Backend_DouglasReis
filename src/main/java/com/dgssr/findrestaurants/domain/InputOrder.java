package com.dgssr.findrestaurants.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputException;
import com.dgssr.findrestaurants.infrastructure.statemachine.OrderStates;

public class InputOrder implements Serializable, Input {

	private static final long serialVersionUID = -237835264768334468L;
	private BigDecimal price;
	private OrderStates status;
	private Integer restaurantId;
	private Integer customerId;
	
	public InputOrder() {
	
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the status
	 */
	public OrderStates getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OrderStates status) {
		this.status = status;
	}

	/**
	 * @return the restaurantId
	 */
	public Integer getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public void checkIfICanContinueUseSearch() {
		if (price == null || status == null || restaurantId == null || customerId == null) {
			throw new InvalidInputException("Alguns desses parameteros não foram encontrados " + "PRICE: "
					+ price + " STATUS: " + status + " RESTAURANT_ID: " + restaurantId + " CUSTOMER_ID: " + customerId);
		}

	}
	
	public static class InputOrderBuilder {
		
		private BigDecimal price;
		private OrderStates status;
		private Integer restaurantId;
		private Integer customerId;
		
		public InputOrderBuilder addRestaurantId(Integer restaurantId) {
			if(restaurantId == null) {
				throw new InvalidInputException("Informe o id do restaurante");
			}
			this.restaurantId = restaurantId;
			return this;
		}

		public InputOrderBuilder addPrice(BigDecimal price) {
			if(price == null) {
				throw new InvalidInputException("Informe o preço do restaurante");
			}
			this.price = price;
			return this;
		}

		public InputOrderBuilder addStatus(OrderStates status) {
			if(status == null) {
				throw new InvalidInputException("Informe o status");
			}
			this.status = status;
			return this;
		}

		public InputOrderBuilder addCustomerId(Integer customerId) {
			if(customerId == null) {
				throw new InvalidInputException("Informe o id do cliente");
			}
			this.customerId = customerId;
			return this;
		}

		public InputOrder build() {
			InputOrder inputOrder = new InputOrder();
			inputOrder.restaurantId = this.restaurantId;
			inputOrder.status = this.status;
			inputOrder.customerId = this.customerId;
			inputOrder.price = this.price;
			inputOrder.checkIfICanContinueUseSearch();
			return inputOrder;
		}

	}

}
