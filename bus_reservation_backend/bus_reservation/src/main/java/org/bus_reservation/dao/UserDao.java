package org.bus_reservation.dao;

import java.util.Optional;

import org.bus_reservation.dto.User;
import org.bus_reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	public Optional<User> findUserById(int user_id){
		return userRepository.findById(user_id);
	}
	public void deleteUserById(int user_id) {
		userRepository.deleteById(user_id);
	}
	public Optional<User> verifyUserByEmail(String email, String password){
		return userRepository.findUserByEmail(email, password);
	}
	public Optional<User> verifyUserByPhone(long phone, String password){
		return userRepository.findUserByPhone(phone, password);
	}
}
