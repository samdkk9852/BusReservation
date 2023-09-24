package org.bus_reservation.service;

import java.util.List;
import java.util.Optional;

import org.bus_reservation.dao.AdminDao;
import org.bus_reservation.dao.BusDao;
import org.bus_reservation.dto.Admin;
import org.bus_reservation.dto.Bus;
import org.bus_reservation.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	
	@Autowired
	private BusDao busDao;
	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus, int admin_id){
		ResponseStructure<Bus> responseStructure = new ResponseStructure<>();
		Optional<Admin> receiveAdmin = adminDao.findAdminById(admin_id);
		
		if(receiveAdmin.isPresent()) {
			Admin admin = receiveAdmin.get();
			admin.getBuses().add(bus);
			bus.setAdmin(admin);
			adminDao.updateAdmin(admin);
			busDao.saveBus(bus);
			
			responseStructure.setResponseData(bus);
			responseStructure.setResponseMessage("Bus Has Been Added");
			responseStructure.setHttpStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Bus>>(responseStructure, HttpStatus.CREATED);
		}
		
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus bus, int admin_id){
		ResponseStructure<Bus> responseStructure = new ResponseStructure<>();
		Optional<Admin> receiveAdmin = adminDao.findAdminById(admin_id);
		if(receiveAdmin.isPresent()) {
			Admin admin = receiveAdmin.get();
			admin.getBuses().add(bus);
			bus.setAdmin(admin);
			adminDao.updateAdmin(admin);
			busDao.updateBus(bus);
			responseStructure.setResponseData(bus);
			responseStructure.setResponseMessage("Bus Has Been Updated");
			responseStructure.setHttpStatus(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Bus>>(responseStructure, HttpStatus.ACCEPTED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Bus>> changeBusRoutes(int bus_id, String from, String to){
		ResponseStructure<Bus> responseStructure = new ResponseStructure<>();
		Optional<Bus> receiveBus = busDao.findBusById(bus_id);
		if(receiveBus.isPresent()) {
			Bus bus = receiveBus.get();
			bus.setFrom(from);
			bus.setTo(to);
			busDao.updateBus(bus);
			responseStructure.setResponseData(bus);
			responseStructure.setResponseMessage("Route of Bus has been changed");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Bus>>(responseStructure, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByRoutes(String from, String to){
		ResponseStructure<List<Bus>> responseStructure = new ResponseStructure<>();
		List<Bus> bus_List = busDao.findBusByRoutes(from, to);
		if(bus_List!=null) {
			responseStructure.setResponseData(bus_List);
			responseStructure.setResponseMessage("All the bus are fetched in that route");
			responseStructure.setHttpStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<List<Bus>>>(responseStructure, HttpStatus.OK);
		}
		return null;

	}
}
