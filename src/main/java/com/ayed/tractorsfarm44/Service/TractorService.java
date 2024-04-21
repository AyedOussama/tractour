package com.ayed.tractorsfarm44.Service;

import com.ayed.tractorsfarm44.Model.Tractor;
import com.ayed.tractorsfarm44.Repository.TractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TractorService {
    @Autowired
    private final TractorRepository tractorRepository;

    public TractorService(TractorRepository tractorRepository) {
        this.tractorRepository = tractorRepository;
    }


    public Tractor createTractor(Tractor tractor) {
        return tractorRepository.save(tractor);
    }


    public Tractor getTractorById(Long id) {
        return tractorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tractor not found with id: " + id));
    }


    public List<Tractor> getAllTractors() {
        return tractorRepository.findAll();
    }


    public Tractor updateTractor(Long id, Tractor tractor) {
        Tractor existingTractor = tractorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tractor not found with id: " + id));

        existingTractor.setMake(tractor.getMake());
        existingTractor.setModel(tractor.getModel());
        existingTractor.setYear(tractor.getYear());
        existingTractor.setDescription(tractor.getDescription());

        return tractorRepository.save(existingTractor);
    }


    public void deleteTractor(Long id) {
        Tractor tractor = tractorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tractor not found with id: " + id));

        tractorRepository.delete(tractor);
    }
}

