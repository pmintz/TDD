package com.example.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CarService {
	@Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name){
        Car car = carRepository.findByName("prius");
        if(car == null){
        	car = new Car("Subaru", "Impreza");
        }

        return car;
    }
}
