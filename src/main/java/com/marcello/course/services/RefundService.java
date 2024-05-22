package com.marcello.course.services;

import com.marcello.course.entities.Refund;
import com.marcello.course.repositories.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefundService {
	
	
	@Autowired
	private RefundRepository refundRepository;


	public List<Refund> findAll() {
		return refundRepository.findAll();

	}

	public Refund findById(Long id) {
		Optional<Refund> obj = refundRepository.findById(id);
		return obj.get();
	}

	public List<Refund> saveAll(List<Refund> order) {
		return refundRepository.saveAll(order);
	}
}
