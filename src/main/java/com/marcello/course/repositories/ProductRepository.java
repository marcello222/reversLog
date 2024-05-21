package com.marcello.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.course.entities.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {	
	

}
