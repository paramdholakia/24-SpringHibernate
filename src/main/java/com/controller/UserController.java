package com.controller;

// Import statements for Spring framework annotations
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Importing the UserEntity class, which likely represents a user in the system
import com.entity.UserEntity;

@Controller  // Marks this class as a Spring MVC controller
public class UserController {

    // Method to handle GET requests for the "/newUser" URL
    // This method returns the name of the view (JSP page) to be rendered
    @GetMapping("/newUser")
    public String newUser() {
        // Returns the name of the JSP file that should be displayed
        // The view resolver will look for a file named "NewUser.jsp"
        return "NewUser";
    }
    
    // Method to handle POST requests for the "/Saveuser" URL
    // This method receives a UserEntity object, which is populated with data from the form submission
    @PostMapping("/Saveuser")
    public String saveUser(UserEntity user) {
        // Print the user's first name to the console for debugging purposes
        System.out.println("First Name: " + user.getFirstName());

        // Print the user's email to the console for debugging purposes
        System.out.println("Email: " + user.getEmail());

        // Print the user's password to the console for debugging purposes
        System.out.println("Password: " + user.getPassword());

        // After processing, return the name of the JSP file to be displayed
        // This will show the "NewUser.jsp" page again
        return "NewUser";
    }
}
