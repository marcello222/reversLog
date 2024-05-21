package com.marcello.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.course.entities.Order;



public interface OrderRepository extends JpaRepository<Order, Long> {	
	

}
