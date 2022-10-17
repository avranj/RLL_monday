package com.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dao.UserDao;
import com.insurance.entity.User;
import com.insurance.service.UserService;

@RestController
public class UserController {
	 @Autowired
	 private UserDao userdao;
	 @Autowired
	 private UserService service;
	 
	 // create user done by Admin only
	 // add user by user but policynum as null
	 
	 @PostMapping("/user")
	 public User saveUser(@RequestBody User user) {
		return service.addUser(user);
		 
	 }
	 
	 // read All user details by Admin only
	 
	 // read by id
	 @GetMapping("/user/{id}")
	 public User findUserById(@PathVariable int id) {
		return service.getUserById(id);
		 
	 }
	 // user details by name
	// @GetMapping("/users/{name}")
	 //public User findUserByName(@PathVariable String name) {
		 
		// return service.getUserByName(name);
		 
	 //} commenting because its not required
	 
	 
	 
	 // update details by user
	 @PutMapping("/user")
	 public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
		 
	 }
	 
	 //delete by user
	 @DeleteMapping("/user/{id}")
	 public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
		 
	 }
	 
	 // Admin can see the whole list of users//
	 
	 // user login part  through userId and password 
	 @PostMapping("/user/login")
	 public String userLogin(@RequestBody User user ) {
		 return service.userLogin(user);
		 
	 }
	 
	 
	 
	 
	 
	 
	 

}
