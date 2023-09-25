package org.bus_reservation.controller;

import java.util.List;

import org.bus_reservation.dto.Bus;
import org.bus_reservation.dto.ResponseStructure;
import org.bus_reservation.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BusController {

	@Autowired
	private BusService busService;
	
	@PostMapping(value="/bus/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus, @PathVariable int admin_id){
		return busService.saveBus(bus, admin_id);
	}
	
	@PutMapping(value="/bus/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus bus, @PathVariable int admin_id){
		return busService.updateBus(bus, admin_id);
	}
	
	@PutMapping(value="/bus/route/{bus_id}")
	public ResponseEntity<ResponseStructure<Bus>> changeRoute(@PathVariable int bus_id, @RequestParam String from, @RequestParam String to){
		return busService.changeBusRoutes(bus_id, from, to);
	}
	
	@GetMapping(value="/bus/route")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByRoutes(@RequestParam String from, @RequestParam String to){
		return busService.findBusByRoutes(from, to);
	}
}
