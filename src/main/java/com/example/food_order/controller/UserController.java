package com.example.food_order.controller;


import com.example.food_order.pojo.UserPojo;
import com.example.food_order.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @GetMapping
    public String getPage() {
        return "Profile";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "user/create";
    }


    @PostMapping("/create")
    public String createUser(@Valid UserPojo userPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/login";
        }

        userService.save(userPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");


        return "redirect:/login";
    }

    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }
    @PostMapping("/update")
    public String updateUser(@Valid UserPojo userPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

//        Map<String, String> requestError = validateRequest(bindingResult);
//        if (requestError != null) {
//            redirectAttributes.addFlashAttribute("requestError", requestError);
//            return "redirect:/editprofile";
//        }

        userService.update(userPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");


        return "redirect:/profile";
    }

}

