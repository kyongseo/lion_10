package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CarExamMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Car car1 = new Car();
        car1.setManufacturer("toyota");
        car1.setSeatCount(5);

        em.persist(car1);

        Car car2 = new Car();
        car2.setManufacturer("Honda");
        car2.setSeatCount(4);

        em.persist(car2);

        Truck truck1 = new Truck();
        truck1.setManufacturer("Volvo");
        truck1.setPayloadCapacity(15.5);

        em.persist(truck1);

        Truck truck2 = new Truck();
        truck2.setManufacturer("Scania");
        truck2.setPayloadCapacity(20.0);

        em.persist(truck2);

        em.getTransaction().commit();

        List<Vehicle> vehicles = em.createQuery("select v from Vehicle v", Vehicle.class).getResultList();
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                log.info("Car info : " + car.getManufacturer());
            } else if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                System.out.println("truck : " + truck.getManufacturer() + "Seat : " + truck.getPayloadCapacity() );

            }
        }
    }
}
