package com.microservices.huntgroup.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.huntgroup.bean.Group;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HuntGroupController {

	private List<Group> groups;
	private Logger logger = Logger.getLogger(HuntGroupController.class.getName());

	public HuntGroupController() {
		this.groups = new ArrayList<>();

		this.groups.add(new Group(1, "HuntGroup 1", "polu.java@gmail.com"));
		this.groups.add(new Group(2, "JHuntGroup 2", "rpolu@gmail.com"));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Group findById(@PathVariable("id") Integer id) {
		this.logger.info(String.format("Groups.findById(%d)", id));
		return this.groups.stream().filter(aut -> aut.getId().intValue() == id.intValue()).findFirst().get();
	}

	@HystrixCommand(fallbackMethod = "getAllCached")
	@RequestMapping(path = "/huntGroups", method = RequestMethod.GET)
	public List<Group> getAll() {
		this.logger.info("Groups.getAll()");
		return this.groups;
	}

	public List<Group> getAllCached() {
		this.logger.info("Groups.getAllCached()");
		this.logger.warning("Return cached result here");

		return new ArrayList<>();
	}
}
