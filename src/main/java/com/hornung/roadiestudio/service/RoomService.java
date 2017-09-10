package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.repository.Rooms;

@Service
public class RoomService {
	
	@Autowired
	private Rooms rooms;
	
	public void save(com.hornung.roadiestudio.model.Room room){

		//TODO regras de negócio
		this.rooms.save(room);
	}
	
	public void delete(int codRoom) {
		this.rooms.delete(codRoom);
	}


}
