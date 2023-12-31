package org.bus_reservation.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String bus_num;
	@Column(nullable = false, name="from_loc")
	private String from;
	@Column(nullable = false, name="to_loc")
	private String to;
	@Column(nullable = false, name="date_of_registeration")
	private LocalDate date_of_reg;
	@Column(nullable = false, name="number_of_seats")
	private int num_of_seat;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Admin admin;
	@OneToMany(mappedBy = "bus")
	private List<Ticket> tickets;
}
