package com.microservices.customer.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.customer.bean.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping
public class CustomersController {

	private List<Customer> customers;
	private Logger logger = Logger.getLogger(CustomersController.class.getName());

	public CustomersController() {
		this.customers = new ArrayList<>();

		this.customers.add(new Customer(1, "Rama Mohan", "polu.java@gmail.com"));
		this.customers.add(new Customer(2, "Rajkumar", "rpolu@gmail.com"));
	}

	@HystrixCommand(fallbackMethod = "getAllCached")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Customer> getAll() {
		this.logger.info("Customers.getAll()");
		return this.customers;
	}

	public List<Customer> getAllCached() {
		this.logger.info("Customers.getAllCached()");
		this.logger.warning("Return cached result here");

		return new ArrayList<>();
	}
}
