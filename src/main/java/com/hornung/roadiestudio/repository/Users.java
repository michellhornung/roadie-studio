package com.hornung.roadiestudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Users extends JpaRepository<com.hornung.roadiestudio.model.User, Integer>{
	
	@Modifying
    @Transactional
    @Query("delete from User u where u.codUser = ?1")
    void deleteUserById(Long codUser);

}
