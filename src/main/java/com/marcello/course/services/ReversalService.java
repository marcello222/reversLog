package com.marcello.course.services;

import com.marcello.course.entities.Order;
import com.marcello.course.entities.Reversal;
import com.marcello.course.repositories.OrderRepository;
import com.marcello.course.repositories.ReversalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReversalService {
	
	
	@Autowired
	private ReversalRepository reversalRepository;


	public List<Reversal> findAll() {
		return reversalRepository.findAll();

	}

	public Reversal findById(Long id) {
		Optional<Reversal> obj = reversalRepository.findById(id);
		return obj.get();
	}

	public List<Reversal> saveAll(List<Reversal> order) {
		return reversalRepository.saveAll(order);
	}
}
