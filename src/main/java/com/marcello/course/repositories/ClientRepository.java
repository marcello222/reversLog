package com.marcello.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.course.entities.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {
	

}
