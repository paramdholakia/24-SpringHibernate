package com.repository;

// Import statements for using specific classes from the Spring framework.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Import statement for using the `RestaurantEntity` class.
import com.entity.RestaurantEntity;

// Annotation that marks this interface as a Spring Data repository.
// This enables Spring Data JPA to automatically provide implementations for common database operations.
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
    // JpaRepository provides basic CRUD operations, no additional methods needed for basic functionality.
}
