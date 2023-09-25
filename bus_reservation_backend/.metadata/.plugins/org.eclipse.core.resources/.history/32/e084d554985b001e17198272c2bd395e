package org.bus_reservation.dao;

import java.util.List;
import java.util.Optional;

import org.bus_reservation.dto.Bus;
import org.bus_reservation.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	
	@Autowired
	private BusRepository busRepository;
	
	public Bus saveBus(Bus bus) {
		return busRepository.save(bus);
	}
	public Bus updateBus(Bus bus) {
		return busRepository.save(bus);
	}
	public Optional<Bus> findBusById(int bus_id){
		return busRepository.findById(bus_id);
	}
	public List<Bus> findBusByRoutes(String from, String to){
		return busRepository.findBusByRoutes(from, to);
	}
}
