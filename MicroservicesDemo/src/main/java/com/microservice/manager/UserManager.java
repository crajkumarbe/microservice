package com.microservice.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservice.bean.UserBean;

@Component
public class UserManager {
	private static ArrayList<UserBean> list = new ArrayList<UserBean>();
	static {
		UserBean user1 = new UserBean();
		user1.setId(1);
		user1.setFirstName("rama");
		user1.setLastName("polu");
		user1.setAddress("Bangalore");

		UserBean user2 = new UserBean();
		user2.setId(2);
		user2.setFirstName("rajkumar");
		user2.setLastName("chandran");
		user2.setAddress("chennai");

		list.add(user1);
		list.add(user2);
	}

	public List<UserBean> getAllUsers() {
		return list;
	}

	public void addUser(UserBean u) {
		UserBean user = new UserBean();
		user.setId(u.getId());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setAddress(u.getAddress());
		list.add(user);
	}

}
