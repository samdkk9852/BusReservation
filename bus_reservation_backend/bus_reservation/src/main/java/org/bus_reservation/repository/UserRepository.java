package org.bus_reservation.repository;

import java.util.Optional;

import org.bus_reservation.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email = ?1 and u.password=?2")
	public Optional<User> findUserByEmail(String email, String password);
	
	@Query("select u from User u where u.phone=?1 and u.password=?2")
	public Optional<User> findUserByPhone(long phone, String password);
}
