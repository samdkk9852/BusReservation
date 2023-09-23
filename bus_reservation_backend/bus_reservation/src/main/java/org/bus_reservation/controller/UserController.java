package org.bus_reservation.controller;

import org.bus_reservation.dto.ResponseStructure;
import org.bus_reservation.dto.User;
import org.bus_reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@PutMapping(value="/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	
	@GetMapping(value="/user/verifyUserByEmail")
	public ResponseEntity<ResponseStructure<User>> verifyUserByEmail(@RequestParam String email, @RequestParam String password){
		return userService.verifyUserByEmail(email, password);
	}
	
	@GetMapping(value="/user/verifyUserByPhone")
	public ResponseEntity<ResponseStructure<User>> verifyUserByPhone(@RequestParam long phone, @RequestParam String password){
		return userService.verifyUserByPhone(phone, password);
	}
}
