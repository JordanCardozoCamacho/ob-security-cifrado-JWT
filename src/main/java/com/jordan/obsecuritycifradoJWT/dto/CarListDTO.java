package com.jordan.obsecuritycifradoJWT.dto;

import com.jordan.obsecuritycifradoJWT.domain.Car;

import java.util.List;

/**
 * Data Transfer Object
 */

public class CarListDTO {

    private List<Car> cars;

    public CarListDTO(){

    }

    public void setCars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars(){
        return this.cars;
    }
}
