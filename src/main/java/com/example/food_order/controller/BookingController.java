package com.example.food_order.controller;

// BookingController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.food_order.repo.BookingRepository;
import com.example.food_order.entity.Booking;

@Controller
@RequestMapping("/tables")
public class BookingController {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/{id}/book")
    public String showBookingForm(@ModelAttribute("bookingForm") Booking booking) {
        return "bookingForm";
    }

    @PostMapping("/{id}/book")
    public String submitBookingForm(@ModelAttribute("bookingForm") Booking booking, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bookingForm";
        }

        // Save the booking to the database
        bookingRepository.save(booking);

        // Add booking details to the model for displaying on the success page
        model.addAttribute("booking", booking);

        return "bookingSuccess";
    }
}
