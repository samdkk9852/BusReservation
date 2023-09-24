package org.bus_reservation.repository;

import java.util.List;

import org.bus_reservation.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	@Query("select b from Bus b where b.from=?1 and b.to=?2")
	public List<Bus> findBusByRoutes(String from, String to);
}
