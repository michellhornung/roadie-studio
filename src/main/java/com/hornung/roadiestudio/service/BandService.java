package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.Band;
import com.hornung.roadiestudio.repository.Bands;

@Service
public class BandService{
	
	@Autowired
	private Bands bands;
	
	public void save(Band band){

		//TODO business rules
		this.bands.save(band);
	}
	
	public void delete(int codBand) {
		this.bands.delete(codBand);
	}


}
