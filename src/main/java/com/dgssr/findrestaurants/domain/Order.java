package com.dgssr.findrestaurants.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.dgssr.findrestaurants.infrastructure.exceptions.InvalidInputException;
import com.dgssr.findrestaurants.infrastructure.statemachine.OrderStates;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	private static final long serialVersionUID = 4276931232495881348L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private BigDecimal price;
	private OrderStates status;
	@OneToOne
	private Restaurant restaurant;
	@OneToOne
	private Customer customer;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	public Order() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static class OrderBuilder {
		private Integer id;
		private BigDecimal price;
		private OrderStates status;
		private Integer restaurantId;
		private Integer customerId;
		private Date createdAt;
		private Date updatedAt;

		public OrderBuilder addId(Integer id) {
			if (id == null) {
				throw new InvalidInputException("Informe o id da ordem");
			}
			this.id = id;
			return this;
		}
		
		public OrderBuilder addCreatedAt(Date createdAt) {
			if (createdAt == null) {
				throw new InvalidInputException("Informe a data de criação");
			}
			this.createdAt = createdAt;
			return this;
		}
		
		public OrderBuilder addUpdatedAt(Date updatedAt) {
			if (updatedAt == null) {
				throw new InvalidInputException("Informe a data de atualização");
			}
			this.updatedAt = updatedAt;
			return this;
		}

		public OrderBuilder addRestaurantId(Integer restaurantId) {
			if (restaurantId == null) {
				throw new InvalidInputException("Informe o id do restaurante");
			}
			this.restaurantId = restaurantId;
			return this;
		}

		public OrderBuilder addPrice(BigDecimal price) {
			if (price == null) {
				throw new InvalidInputException("Informe o preço do restaurante");
			}
			this.price = price;
			return this;
		}

		public OrderBuilder addStatus(OrderStates status) {
			if (status == null) {
				throw new InvalidInputException("Informe o status");
			}
			this.status = status;
			return this;
		}

		public OrderBuilder addCustomerId(Integer customerId) {
			if (customerId == null) {
				throw new InvalidInputException("Informe o id do cliente");
			}
			this.customerId = customerId;
			return this;
		}

		public Order build() {
			Order order = new Order();
			order.id = this.id;
			order.restaurant = new Restaurant(this.restaurantId);
			order.status = this.status;
			order.customer = new Customer(this.customerId);;
			order.price = this.price;
			order.createdAt = this.createdAt;
			order.updatedAt = this.updatedAt;
			return order;
		}

	}

}
