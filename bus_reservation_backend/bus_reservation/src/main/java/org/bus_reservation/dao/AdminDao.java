package org.bus_reservation.dao;

import java.util.Optional;

import org.bus_reservation.dto.Admin;
import org.bus_reservation.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public Optional<Admin> findAdminById(int admin_id){
		return adminRepository.findById(admin_id);
	}
	public Optional<Admin> verifyAdminByEmail(String email, String password){
		return adminRepository.findAdminByEmail(email, password);
	}
	public Optional<Admin> verifyAdminByEmail(long phone, String email){
		return adminRepository.findAdminByPhone(phone, email);
	}
	public void deleteAdmin(int admin_id) {
		adminRepository.deleteById(admin_id);
	}
}
