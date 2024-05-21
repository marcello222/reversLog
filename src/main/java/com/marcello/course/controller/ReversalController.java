package com.marcello.course.controller;


import com.marcello.course.entities.Reversal;
import com.marcello.course.services.ReversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reversal")
public class ReversalController {

    @Autowired
    private ReversalService reversalService;


    @GetMapping
    public ResponseEntity<List<Reversal>> findAll() {
        List<Reversal> list = reversalService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reversal> findById(@PathVariable Long id) {
        Reversal obj = reversalService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<List<Reversal>> saveAll(List<Reversal> order) {
        List<Reversal> saveList = reversalService.saveAll(order);
        return ResponseEntity.ok(saveList);
    }

}
