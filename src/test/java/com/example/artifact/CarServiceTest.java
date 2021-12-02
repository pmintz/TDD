package com.example.artifact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.assertj.core.api.iterable.Extractor;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest{

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() throws Exception{
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnsCarInfo(){
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");

        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");

    }

    @Test//(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound() throws Exception{
        given(carRepository.findByName("prius")).willReturn(null);

        assertThat(carService.getCarDetails("prius")).extracting(
        		(Extractor<Car, String>)Car::getName).isEqualTo("Subaru") ;
    }
}
