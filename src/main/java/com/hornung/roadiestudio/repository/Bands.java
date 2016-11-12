package com.hornung.roadiestudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hornung.roadiestudio.model.Band;

public interface Bands extends JpaRepository<Band, Integer>{

}
