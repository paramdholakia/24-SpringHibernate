package com.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    
    @NotEmpty(message = "Restaurant name cannot be null or empty")
    @Pattern(regexp = "[a-zA-Z\\s]+", message="Please enter a valid restaurant name")
    private String restaurantName;
    
    @NotEmpty(message = "Restaurant address cannot be null or empty")
    private String restaurantAddress;
    
    @NotEmpty(message = "Restaurant category cannot be null or empty")
    @Length(min = 3, max = 20, message = "Please enter between 3 and 20 characters")
    private String restaurantCategory;
}
