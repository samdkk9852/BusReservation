package org.bus_reservation.controller;

import org.bus_reservation.dto.Admin;
import org.bus_reservation.dto.ResponseStructure;
import org.bus_reservation.service.AdminService;
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
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(value="/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping(value="/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	
	@GetMapping(value="/admin/verifyAdminByEmail")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdminByEmail(@RequestParam String email, @RequestParam String password){
		return adminService.verifyAdminByEmail(email, password);
	}
	
	@GetMapping(value="/admin/verifyAdminByPhone")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdminByPhone(@RequestParam long phone, @RequestParam String password){
		return adminService.verifyAdminByPhone(phone, password);
	}
}
