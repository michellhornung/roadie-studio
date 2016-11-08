package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.BandGenre;
import com.hornung.roadiestudio.repository.BandGenres;

@Service
public class BandGenreService {
	
	@Autowired
	private BandGenres bandGenres;
	
	public void save(BandGenre bandGenre){

		//TODO regras de negócio
		this.bandGenres.save(bandGenre);
	}
	
	public void delete(int codBandGenre) {
		this.bandGenres.delete(codBandGenre);
	}


}
