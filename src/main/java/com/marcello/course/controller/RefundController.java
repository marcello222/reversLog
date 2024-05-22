package com.marcello.course.controller;


import com.marcello.course.entities.Refund;
import com.marcello.course.services.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reversal")
public class RefundController {

    @Autowired
    private RefundService refundService;


    @GetMapping
    public ResponseEntity<List<Refund>> findAll() {
        List<Refund> list = refundService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Refund> findById(@PathVariable Long id) {
        Refund obj = refundService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<List<Refund>> saveAll(List<Refund> order) {
        List<Refund> saveList = refundService.saveAll(order);
        return ResponseEntity.ok(saveList);
    }

}
