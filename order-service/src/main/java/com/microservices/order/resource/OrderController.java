package com.microservices.order.resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.order.bean.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderController {

	private List<Order> orders;
	private Logger logger = Logger.getLogger(OrderController.class.getName());

	public OrderController() {
		this.orders = new ArrayList<>();
		this.orders.add(new Order(1, "Book", new Date(), 10.7f));
		this.orders.add(new Order(2, "Pen", new Date(), 2.89f));
		this.orders.add(new Order(3, "Paper", new Date(), 90.f));
	}

	@HystrixCommand(fallbackMethod = "getAllCached")
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Order> getAll() {
		this.logger.info("Orders.getAll()");
		return this.orders;
	}

	public List<Order> getAllCached() {
		this.logger.info("Orders.getAllCached()");
		this.logger.warning("Return cached result here");
		return new ArrayList<>();
	}
}
