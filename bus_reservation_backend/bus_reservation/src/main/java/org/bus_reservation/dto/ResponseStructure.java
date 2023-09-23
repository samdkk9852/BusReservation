package org.bus_reservation.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T responseData;
	private String responseMessage;
	private int httpStatus;
	
}
