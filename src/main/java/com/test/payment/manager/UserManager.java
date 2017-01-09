package com.test.payment.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.payment.domain.User;
import com.test.payment.domain.UserType;

@Component
public class UserManager {

	List<User> list = new ArrayList<User>();

	public String createUser(User user) {
		list.add(user);
		user.setId(list.size()+" ") ;
		
		return Math.random() + "";
	}

	public List<User> getAll() {
	return  list;
	}

	public List<User> getAllByType(UserType type) {
		List<User> listByType = new ArrayList<User>() ;
		for (User user : list) {
			if (user.getType().equals(type)) {
				listByType.add(user) ;
			}
		}
		return  listByType;
	}
}
