package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Setter@Getter
@NoArgsConstructor
public abstract class Vehicle2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}

@Entity
@DiscriminatorValue("CAR")
@Setter@Getter
@Table(name = "Car2")
class Car2 extends Vehicle2 {
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")
@Setter@Getter
@Table(name = "Truck2")
class Truck2 extends Vehicle2 {
    private double payloadCapacity;
}
