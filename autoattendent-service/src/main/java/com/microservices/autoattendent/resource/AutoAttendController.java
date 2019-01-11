package com.microservices.autoattendent.resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.autoattendent.bean.Group;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AutoAttendController {

	private List<Group> groups;
	private Logger logger = Logger.getLogger(AutoAttendController.class.getName());

	public AutoAttendController() {
		this.groups = new ArrayList<>();
		this.groups.add(new Group(1, "Group 1", new Date(), 1));
		this.groups.add(new Group(2, "Group 2", new Date(), 2));
		this.groups.add(new Group(3, "Group 3", new Date(), 2));
		this.groups.add(new Group(4, "Group 4", new Date(), 1));
		this.groups.add(new Group(5, "Group 5", new Date(), 1));
	}

	@HystrixCommand(fallbackMethod = "getAllCached")
	@RequestMapping(path = "/", method = RequestMethod.GET)
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
