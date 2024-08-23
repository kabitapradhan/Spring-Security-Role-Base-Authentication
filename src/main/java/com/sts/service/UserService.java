package com.sts.service;

import java.util.List;

import com.sts.entity.User;

public interface UserService {
	User createUser(User user);
	List<User> getAllUser();
	User getUserById(String id) throws Exception;
	User updateUser(User user , String id);
	void deleteUser(String id);
}
