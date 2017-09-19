package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.Recording;
import com.hornung.roadiestudio.repository.Recordings;

@Service
public class RecordingService {
	
	@Autowired
	private Recordings recordings;
	
	public void save(Recording recording){

		//TODO regras de negócio
		this.recordings.save(recording);
	}
	
	public void delete(int codRecording) {
		this.recordings.delete(codRecording);
	}


}
