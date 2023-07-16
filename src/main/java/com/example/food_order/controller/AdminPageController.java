package com.example.food_order.controller;

import com.example.food_order.entity.AdminPage;
import com.example.food_order.pojo.AdminPagePojo;
import com.example.food_order.services.AdminPageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/th-admindashboard")
@RequiredArgsConstructor
public class AdminPageController {
    private final AdminPageService adminPageService;

    @GetMapping("getById/{id}")
    public Optional<AdminPage> getById(@PathVariable Integer id) {
        return adminPageService.getById(id);
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable Integer id) {
        adminPageService.deleteById(id);
        return "deleted successfully";
    }


    @PostMapping("save")
    public String saveData(@Valid AdminPagePojo adminPagePojo,
                           BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);

            return null;
        }
        adminPageService.saveData(adminPagePojo);
        return "data saved";
    }


    @GetMapping("getAll")
    public List<AdminPage> getAllData() {
        return adminPageService.getAllData();
    }

    @GetMapping("fetchById/{id}")
    public Optional<AdminPage> fetchById(@PathVariable Integer id){
        return adminPageService.fetchById(id);
    }

    @DeleteMapping("dropById/{id}")
    public String dropById(@PathVariable Integer id){
        adminPageService.dropById(id);
        return "deleted successfully";
    }
}

