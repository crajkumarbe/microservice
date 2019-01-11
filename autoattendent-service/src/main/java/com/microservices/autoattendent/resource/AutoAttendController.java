package com.microservices.autoattendent.resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.microservices.autoattendent.bean.Group;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Group findById(@PathVariable("id") Integer id) {
		this.logger.info(String.format("Groups.findById(%d)", id));
		return this.groups.stream().filter(article -> article.getId().intValue() == id.intValue()).findFirst().get();
	}

	@RequestMapping(path = "/autoattendent/{groupId}", method = RequestMethod.GET)
	public List<Group> findByAuthor(@PathVariable("groupId") final Integer groupId) {
		this.logger.info(String.format("Groups.findByGroup(%d)", groupId));
		return this.groups.stream().filter(article -> article.getAuthorId().intValue() == groupId.intValue())
				.collect(Collectors.toList());
	}

	@HystrixCommand(fallbackMethod = "getAllCached")
	@RequestMapping(path = "/autoattendents", method = RequestMethod.GET)
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
