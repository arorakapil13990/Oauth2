package com.oauth.springBootOauth.model.service;

import java.util.List;

import com.oauth.springBootOauth.model.User;

public interface UserService {
	
	public List<User> findAll();
	
	public void delete(long id);

}
