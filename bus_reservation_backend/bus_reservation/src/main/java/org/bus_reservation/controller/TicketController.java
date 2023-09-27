package org.bus_reservation.controller;

import org.bus_reservation.dto.ResponseStructure;
import org.bus_reservation.dto.Ticket;
import org.bus_reservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	public ResponseEntity<ResponseStructure<Ticket>> bookTicket(@RequestBody Ticket ticket, @PathVariable int user_id, @PathVariable int bus_id){
		return ticketService.bookTicket(ticket, user_id, bus_id);
	}
}
