package com.jasonkung.springboot.repositories;

import com.jasonkung.springboot.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long>{

}
