package com.example.food_order.controller;

import com.example.food_order.entity.User;
import com.example.food_order.pojo.OrderListPojo;
import com.example.food_order.services.OrderService;
import com.example.food_order.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class CheckoutController {
    private final OrderService orderService;
    private final UserService userService;
    @GetMapping("/checkout")
    public String getStartPage(Model model){
        model.addAttribute("total", grandTotal());
        return "addcard/checkout.html";
    }
    public int grandTotal(){
        List<Object> orderList=this.orderService.getOrderList(getUser(getCurrentUser()).getId());
        List<OrderListPojo> orderListPojo=new ArrayList<>();
        orderList.stream().forEach(i->{
            OrderListPojo order = new OrderListPojo();
            order.setItem_price((String) Array.get(i,4));
            orderListPojo.add(order);
        });
        int total = 0;
        for(OrderListPojo ad : orderListPojo){
            String unPrice = ad.getItem_price();
            String tempPrice = "";
            for(int i = 3; i < unPrice.length(); i++){
                char c = unPrice.charAt(i);
                if (Character.isDigit(c)) {
                    tempPrice += c;
                }
            }
            if (!tempPrice.isEmpty()) {
                total += Integer.parseInt(tempPrice);
            }
        }
        return total;
    }
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentemail = authentication.getName();
        return currentemail;
    }

    public User getUser(String email){
        User u = userService.fatchByEmail(email);
        return u;
    }
}
