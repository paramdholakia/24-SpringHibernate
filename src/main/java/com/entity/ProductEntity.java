package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Annotation that marks this class as a JPA entity, meaning it will be mapped to a database table.
@Entity

// Annotation that specifies the name of the database table that this entity will be mapped to.
// Here, the table name is `products`.
@Table(name = "products")

// Lombok annotation that sets the default access level for all fields in the class to `private`.
// This means all fields will be private unless explicitly specified otherwise.
@FieldDefaults(level = AccessLevel.PRIVATE)

// Lombok annotation to generate getter methods for all fields in the class.
@Getter

// Lombok annotation to generate setter methods for all fields in the class.
@Setter

// Lombok annotation to generate a no-argument constructor. This is required by JPA.
@NoArgsConstructor

// Lombok annotation to generate an all-arguments constructor. This allows creating an instance of the entity with specific values.
@AllArgsConstructor
public class ProductEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Field representing the primary key of the product entity.
    Integer productId;
    
    // Field representing the name of the product.
    String productName;
    
    // Field representing the price of the product.
    Float price;
    
    // Field representing the category of the product, such as "Electronics", "Furniture", etc.
    String category;
}
