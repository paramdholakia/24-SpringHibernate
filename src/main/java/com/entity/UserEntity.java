package com.entity;

// Importing JPA annotations for ORM (Object-Relational Mapping)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  // Marks this class as a JPA entity, meaning it will be mapped to a table in the database
@Table(name = "users")  // Specifies the name of the table in the database that this entity will be mapped to
public class UserEntity {

	@Id  // Marks this field as the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Specifies that the primary key will be auto-generated by the database
	private Integer id;  // The unique identifier for each user

	private String firstName;  // The user's first name
	private String email;  // The user's email address
	private String password;  // The user's password

	// Default constructor (no-argument constructor)
	// Required by JPA for entity instantiation
	public UserEntity() {
	}

	// Parameterized constructor
	// Allows creating a new UserEntity object with specified values for firstName, email, and password
	public UserEntity(String firstName, String email, String password) {
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	// Getter and Setter methods for each field
	// These methods allow access to and modification of the entity's properties

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
