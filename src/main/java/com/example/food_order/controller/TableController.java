package com.example.food_order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/table")
public class TableController {

    @GetMapping("/booking")
    public String showBookingForm() {
        return "booking-form"; // The name of the Thymeleaf template for the booking form
    }

    @PostMapping("/booking")
    public String submitBookingForm(
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            Model model
    ) {
        // Process the data, fetch additional data from the backend, etc.
        // You can use the 'name' and 'date' parameters to access the submitted values

        // Example: Fetching additional data
        String additionalData = fetchDataFromBackend();

        // Add the fetched data to the model to be used in the Thymeleaf template
        model.addAttribute("additionalData", additionalData);

        return "booking-success"; // The name of the Thymeleaf template for the booking success page
    }

    private String fetchDataFromBackend() {
        // Implement the logic to fetch data from the backend
        // You can make database queries, call APIs, etc. here
        // Return the fetched data as needed
        return "Fetched data from the backend";
    }
}

