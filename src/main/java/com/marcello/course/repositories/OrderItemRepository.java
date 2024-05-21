package com.marcello.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.course.entities.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {	
	

}
