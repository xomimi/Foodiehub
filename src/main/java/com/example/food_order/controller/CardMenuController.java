package com.example.food_order.controller;

import com.example.food_order.entity.Order;
import com.example.food_order.pojo.OrderListPojo;
import com.example.food_order.repo.OrderRepo;
import com.example.food_order.services.AdminPageService;
import com.example.food_order.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardMenuController {

    private final OrderService orderService;
    private final AdminPageService adminPageService;
    private final OrderRepo orderRepo;

    @GetMapping("/cardmenu/{user_id}")
    public String getStartPage(@PathVariable Integer user_id, Model model) {
        List<Object> orderList=this.orderService.getOrderList(user_id);
        List<OrderListPojo> orderListPojo=new ArrayList<>();
        orderList.stream().forEach(i->{
            OrderListPojo order = new OrderListPojo();
            order.setId((Integer) Array.get(i,0));
            order.setImage(getImageBase64((String) Array.get(i,3)));
            order.setItem_price((String) Array.get(i,4));
            order.setItem_name((String) Array.get(i,5));


            orderListPojo.add(order);
        });
        model.addAttribute("orderListPojo",orderListPojo );
        return "addcard/cardmenu.html";
    }

    @GetMapping("delete/{id}")
    public String getDeleteData(@PathVariable Integer id){
        Order order=orderRepo.findById(id).get();
        String uid = order.getUser().getId().toString();
        orderService.deleteById(id);
        return "redirect:/card/cardmenu/" + uid;
    }



    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/file_server/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }

}
