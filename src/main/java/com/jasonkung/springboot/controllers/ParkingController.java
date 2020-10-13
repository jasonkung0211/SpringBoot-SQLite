package com.jasonkung.springboot.controllers;

import java.util.List;

import com.jasonkung.springboot.repositories.ParkingRepository;
import com.jasonkung.springboot.model.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ParkingController {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    public ParkingController(ParkingRepository repository) {
        this.parkingRepository = repository;
    }

    // test
    //http://localhost:8004/springboot/get
	
	@GetMapping("/get")
	public List<Parking> get() {
		return parkingRepository.findAll();
	}
}