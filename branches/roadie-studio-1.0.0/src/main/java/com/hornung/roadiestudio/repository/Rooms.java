package com.hornung.roadiestudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hornung.roadiestudio.model.Room;

public interface Rooms extends JpaRepository<Room, Integer>{

}