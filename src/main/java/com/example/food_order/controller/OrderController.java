package com.example.food_order.controller;

import com.example.food_order.pojo.OrderPojo;
import com.example.food_order.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/saveorder")
    public String saveOrder(@Valid OrderPojo orderPojo, Model model) throws IOException {
        model.addAttribute("orderPojo",new OrderPojo());
        orderService.saveData(orderPojo);

        return "redirect:/th-home/create";
    }
}
