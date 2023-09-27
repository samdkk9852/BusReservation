package org.bus_reservation.service;

import java.util.Optional;

import org.bus_reservation.dao.BusDao;
import org.bus_reservation.dao.TicketDao;
import org.bus_reservation.dao.UserDao;
import org.bus_reservation.dto.Bus;
import org.bus_reservation.dto.ResponseStructure;
import org.bus_reservation.dto.Ticket;
import org.bus_reservation.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BusDao busDao;
	
	public ResponseEntity<ResponseStructure<Ticket>> bookTicket(Ticket ticket, int user_id, int bus_id){
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<>();
		Optional<Bus> receiveBus = busDao.findBusById(bus_id);
		Optional<User> receiveUser = userDao.findUserById(user_id);
		if(receiveBus.isPresent() && receiveUser.isPresent()) {
			Bus bus = receiveBus.get();
			User user = receiveUser.get();
			bus.getTickets().add(ticket);
			user.getTickets().add(ticket);
			ticket.setBus(bus);
			ticket.setUser(user);
			ticketDao.bookTicket(ticket);
			busDao.updateBus(bus);
			userDao.updateUser(user);
			
			responseStructure.setResponseData(ticket);
			responseStructure.setResponseMessage("Ticket has been booked");
			responseStructure.setHttpStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(Ticket ticket, int user_id, int bus_id){
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<>();
		Optional<User> receiveUser = userDao.findUserById(user_id);
		Optional<Bus> receiveBus = busDao.findBusById(bus_id);
		if(receiveUser.isPresent() && receiveBus.isPresent()) {
			Bus bus = receiveBus.get();
			User user = receiveUser.get();
			bus.getTickets().add(ticket);
			user.getTickets().add(ticket);
			ticketDao.updateTicket(ticket);
			busDao.updateBus(bus);
			userDao.updateUser(user);
			
			responseStructure.setResponseData(ticket);
			responseStructure.setResponseMessage("ticket has been updated");
			responseStructure.setHttpStatus(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.ACCEPTED);
		}
		return null;
	}
}
