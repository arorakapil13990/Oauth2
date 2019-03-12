package com.oauth.springBootOauth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth.springBootOauth.model.User;
import com.oauth.springBootOauth.model.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/users/all")
	public List<User> findAllUser() {
		return service.findAll();
	}

	@RequestMapping("/users/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "Success";
	}
}
