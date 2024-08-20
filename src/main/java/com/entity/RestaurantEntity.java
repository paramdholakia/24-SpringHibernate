package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotation that marks this class as a JPA entity. This means it will be mapped to a database table.
@Entity
// Annotation that specifies the name of the database table that this entity will be mapped to.
// Here, the table name is `restaurants`.
@Table(name = "restaurants")

// Lombok annotations to generate getters, setters, toString, equals, and hashCode methods.
@Data
// Lombok annotation to generate a no-argument constructor.
@NoArgsConstructor
// Lombok annotation to generate an all-arguments constructor.
@AllArgsConstructor
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // This field represents the primary key of the restaurant entity.

    private String restaurantName;
    private String restaurantAddress;
    private String restaurantCategory;
}
