package com.ayed.tractorsfarm44.Repository;

import com.ayed.tractorsfarm44.Model.Tractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TractorRepository extends JpaRepository<Tractor, Long> {

}
