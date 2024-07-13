package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Setter@Getter
@NoArgsConstructor
public abstract class Vehicle3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}

@Entity
@DiscriminatorValue("CAR")
@Setter@Getter
class Car3 extends Vehicle3 {
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")
@Setter@Getter
class Truck3 extends Vehicle3 {
    private double payloadCapacity;
}
