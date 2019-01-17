package com.microservices.order.bean;

import java.util.Date;

public class Order {

	private Integer id;
	private String name;
	private Date orderDate;
	private float price;

	public Order(Integer id, String name, Date orderDate, float price) {
		this.id = id;
		this.name = name;
		this.orderDate = orderDate;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
