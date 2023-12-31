package com.jordan.obsecuritycifradoJWT.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave primaria ficticio tipo Long autoincremental")
    private Long id;

    @Column(name = "fabricante") //Cambiar el nombre a una columna
    private String manufacturer;
    private String model; //CONTAINS
    private Double cc;
    private Integer doors;

    private Integer year;
    private LocalDate releaseDate; //BETWEEN
    private Boolean available; //True or False

    //Constructor
    public Car(){

    }

    //Methods


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    //ToString

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", cc=" + cc +
                ", doors=" + doors +
                ", year=" + year +
                ", releaseDate=" + releaseDate +
                ", available=" + available +
                '}';
    }
}
