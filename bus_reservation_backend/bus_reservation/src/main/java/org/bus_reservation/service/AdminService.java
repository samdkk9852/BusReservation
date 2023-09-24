package org.bus_reservation.service;

import java.util.Optional;

import org.bus_reservation.dao.AdminDao;
import org.bus_reservation.dto.Admin;
import org.bus_reservation.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setResponseData(adminDao.saveAdmin(admin));
		responseStructure.setResponseMessage("Admin data has been saved");
		responseStructure.setHttpStatus(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin){
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setResponseData(adminDao.updateAdmin(admin));
		responseStructure.setResponseMessage("Admin Data has been updated");
		responseStructure.setHttpStatus(HttpStatus.ACCEPTED.value());
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdminByEmail(String email, String password){
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		Optional<Admin> receiveAdmin = adminDao.verifyAdminByEmail(email, password);
		if(receiveAdmin.isPresent()) {
			responseStructure.setResponseData(receiveAdmin.get());
			responseStructure.setResponseMessage("Admin Found");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdminByPhone(long phone, String email){
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		Optional<Admin> receiveAdmin = adminDao.verifyAdminByEmail(phone, email);
		if(receiveAdmin.isPresent()) {
			responseStructure.setResponseData(receiveAdmin.get());
			responseStructure.setResponseMessage("Admin Found");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
		return null;
	}
	
	
}
