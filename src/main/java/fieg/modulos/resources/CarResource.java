package com.estudo.resources;

import com.estudo.model.Car;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cars")
public class CarResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> list() {
        return Car.listAll();
    }

    @POST
    @Transactional
    public Car create(Car car){
        car.persist();
        return car;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Car update(@PathParam("id") Long id, Car car){
            Car carDataBase =  Car.findById(id);
            carDataBase.name = car.name;
            return carDataBase;
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        Car.deleteById(id);
    }
}