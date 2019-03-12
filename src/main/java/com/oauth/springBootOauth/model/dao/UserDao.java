package com.oauth.springBootOauth.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oauth.springBootOauth.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUserName(String userName);

}
