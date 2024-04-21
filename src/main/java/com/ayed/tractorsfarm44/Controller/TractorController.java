package com.ayed.tractorsfarm44.Controller;


import com.ayed.tractorsfarm44.Model.Tractor;
import com.ayed.tractorsfarm44.Service.TractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tractors")
public class TractorController {
    @Autowired
    private TractorService tractorService;

    @PostMapping
    public ResponseEntity<Tractor> createTractor(@RequestBody Tractor tractor) {
        Tractor createdTractor = tractorService.createTractor(tractor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTractor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tractor> getTractorById(@PathVariable Long id) {
        Tractor tractor = tractorService.getTractorById(id);
        return ResponseEntity.ok(tractor);
    }

    @GetMapping
    public ResponseEntity<List<Tractor>> getAllTractors() {
        List<Tractor> tractors = tractorService.getAllTractors();
        return ResponseEntity.ok(tractors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tractor> updateTractor(@PathVariable Long id, @RequestBody Tractor tractor) {
        Tractor updatedTractor = tractorService.updateTractor(id, tractor);
        return ResponseEntity.ok(updatedTractor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTractor(@PathVariable Long id) {
        tractorService.deleteTractor(id);
        return ResponseEntity.noContent().build();
    }
}

