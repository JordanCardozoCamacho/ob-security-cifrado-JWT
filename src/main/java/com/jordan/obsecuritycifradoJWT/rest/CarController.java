package com.jordan.obsecuritycifradoJWT.rest;

import com.jordan.obsecuritycifradoJWT.domain.Car;
import com.jordan.obsecuritycifradoJWT.repository.UserRepository;
import com.jordan.obsecuritycifradoJWT.service.CarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

    private final Logger log = LoggerFactory.getLogger(CarController.class);

    private CarService carService;

    //Constructor
    public CarController(CarService carService){
        this.carService = carService;

    }

    //================== SPRING CRUD METHODS ==================

    /**
     * Buscar un auto
     * @param id
     * @return
     */
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> findById(@ApiParam("Clave primaria car") @PathVariable Long id){
        log.info("REST request to find one car");
        Optional<Car> optional = this.carService.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        } else{
            return ResponseEntity.notFound().build();
        }

    }

    /**
     * Listar todos los Autos
     * @return
     */
    @GetMapping("/cars")
    public List<Car> findAll(){
        log.info("REST request to find all cars");
        Long count = carService.count();
        if(count > 0)
            return this.carService.findAll();
        return null;
    }

    /**
     * Crear un auto
     * @param car
     * @return
     */
    @PostMapping("/cars")
    public ResponseEntity<Car> create(@RequestBody Car car){
        log.info("REST request to create a new car");
        if(car.getId() != null){ //Quiere decir que si hay ID, no se puede crear, por lo que el sistema
                                 // lo asigna de manera automatica
            log.warn("Trying yo create a new car with existent id");
            return ResponseEntity.badRequest().build();
        } else{
            return ResponseEntity.ok(this.carService.save(car));
        }
    }

    /**
     * Actualizar un Auto
     * @param car
     * @return
     */
    @PutMapping("/cars")
    public ResponseEntity<Car> update(@RequestBody Car car){
        log.info("REST request to update an existing car");
        if(car.getId() == null){ //No hay ID por lo tanto no hay coche para actualizar
            log.warn("Trying to update an existing car without id");
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(this.carService.save(car));
        }


    }

    /**
     * Eliminar un Auto
     * @param id
     * @return
     */
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteById(@PathVariable Long id){
        log.info("REST request to delete an existing car");
        Optional<Car> optional = this.carService.findById(id);
        if(optional.isPresent()){
            this.carService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Trying to delete car with wrong id");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cars")
    public ResponseEntity<Car> deleteAll(@RequestBody Car car){
        log.info("REST request to delete all cars");
        Long count = this.carService.count();
        if(count > 0){
            this.carService.deleteAll();
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Failed to delete all cars");
            return ResponseEntity.notFound().build();
        }
    }

    //================== CUSTOM CRUD METHODS ==================

    /**
     * Filtrar por fabricante y modelo
     * @param manufacturer
     * @param model
     * @return
     */
    @GetMapping("/cars/manufacturer/{manufacturer}/model/{model}")
    public List<Car> findByManufacturerAndModel(@PathVariable String manufacturer, String model){
        return this.carService.findByManufacturerAndModel(manufacturer,model);

    }

    /**
     * Buscar un Auto por el número de puertas
     * @param doors
     * @return
     */
    @GetMapping("/cars/doors/{doors}")
    @ApiOperation(value = "Buscar Autos filtrando por número de puertas")
    public List<Car> finbyId(@PathVariable Integer doors){
        log.info("REST request to fin cars buy num doors");
        return this.carService.findByDoors(doors);
    }

    /**
     * Buscar Autos por mayor igual a numero de puertas
     * @param doors
     * @return
     */
    @GetMapping("/cars/doors-gte/{doors}")
    public List<Car> findByDoorsGreaterThanEqual(@PathVariable Integer doors){
        return this.carService.findByDoorsGreaterThanEqual(doors);
    }

}
