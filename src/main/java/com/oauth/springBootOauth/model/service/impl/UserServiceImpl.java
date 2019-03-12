package com.oauth.springBootOauth.model.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth.springBootOauth.model.User;
import com.oauth.springBootOauth.model.dao.UserDao;
import com.oauth.springBootOauth.model.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService , UserDetailsService {
	
	@Autowired
	private UserDao dao;

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		dao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		User user = dao.findByUserName(arg0);
		if(user == null){
			throw new UsernameNotFoundException(arg0 +":: User Not Found");
		}
	return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
		
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
