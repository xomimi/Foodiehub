package com.example.food_order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @GetMapping("/booking")
    public String showBookingForm() {
        return "bookingform";
    }

    @PostMapping("/booking")
    public String processBookingForm(@RequestParam("name") String name,
                                     @RequestParam("email") String email,
                                     @RequestParam("date") String date,
                                     Model model) {
        // Process the form submission and save the booking details to the database
        // ...

        // Add the booking details to the model for displaying on the next page
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("date", date);

        // Redirect to the success page
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
