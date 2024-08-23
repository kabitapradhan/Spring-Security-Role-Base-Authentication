package com.sts.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entity.User;
import com.sts.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public User createUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setId(id);
		return this.repo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public User getUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		User user = this.repo.findById(id).orElseThrow(()-> new Exception("User not found with id"+id));
		return user;
	}

	@Override
	public User updateUser(User user, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub

	}

}
