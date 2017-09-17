package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.Rental;
import com.hornung.roadiestudio.repository.Rentals;

@Service
public class RentalService {
	
	@Autowired
	private Rentals rentals;
	
	public void save(Rental rental){

		//TODO regras de negócio
		this.rentals.save(rental);
	}
	
	public void delete(int codRental) {
		this.rentals.delete(codRental);
	}


}
