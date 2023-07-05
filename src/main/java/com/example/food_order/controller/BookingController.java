//package com.example.food_order.controller;
//
//import com.example.food_order.entity.Booking;
//import com.example.food_order.repo.BookingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class BookingController {
//    private final BookingRepository bookingRepository;
//
//    @Autowired
//    public BookingController(BookingRepository bookingRepository) {
//        this.bookingRepository = bookingRepository;
//    }
//
//    @GetMapping("/booking-form")
//    public String showBookingForm(Model model) {
//        model.addAttribute("booking", new Booking());
//        return "booking-form";
//    }
//
//    @PostMapping("/booking-form")
//    public String processBookingForm(Booking booking) {
//        bookingRepository.save(booking);
//        return "booking-success";
//    }
//}
