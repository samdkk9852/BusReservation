package org.bus_reservation.service;

import java.util.Optional;

import org.bus_reservation.dao.UserDao;
import org.bus_reservation.dto.ResponseStructure;
import org.bus_reservation.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setResponseData(userDao.saveUser(user));
		responseStructure.setResponseMessage("User has been Saved");
		responseStructure.setHttpStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setResponseData(userDao.updateUser(user));
		responseStructure.setResponseMessage("User has been Updated");
		responseStructure.setHttpStatus(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUserByEmail(String email, String password){
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		Optional<User> receiveUser = userDao.verifyUserByEmail(email, password);
		if(receiveUser.isPresent()) {
			responseStructure.setResponseData(receiveUser.get());
			responseStructure.setResponseMessage("User Found");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUserByPhone(long phone, String password){
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		Optional<User> receiveUser = userDao.verifyUserByPhone(phone, password);
		if(receiveUser.isPresent()) {
			responseStructure.setResponseData(receiveUser.get());
			responseStructure.setResponseMessage("User Found");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUser(int user_id){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		Optional<User> receiveUser = userDao.findUserById(user_id);
		if(receiveUser.isPresent()) {
			userDao.deleteUserById(user_id);
			responseStructure.setResponseData("User has been deleted");
			responseStructure.setResponseMessage("User Found");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		}
		return null;
	}
}