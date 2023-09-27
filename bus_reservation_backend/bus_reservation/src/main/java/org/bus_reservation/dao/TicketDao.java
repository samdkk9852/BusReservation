package org.bus_reservation.dao;

import org.bus_reservation.dto.Ticket;
import org.bus_reservation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	public Ticket bookTicket(Ticket ticket){
		return ticketRepository.save(ticket);
	}
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
}
