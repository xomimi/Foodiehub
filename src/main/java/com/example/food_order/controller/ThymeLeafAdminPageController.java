package com.example.food_order.controller;

import com.example.food_order.entity.AdminPage;
import com.example.food_order.pojo.AdminPagePojo;
import com.example.food_order.services.AdminPageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Controller
@RequestMapping("/th-admin")
@RequiredArgsConstructor
public class ThymeLeafAdminPageController {

    private final AdminPageService adminPageService;
    @GetMapping("/create")
    public String getFormPage(Model model){
        model.addAttribute("adminPagePojo", new AdminPagePojo());
        model.addAttribute("items",adminPageService.getAllData().stream().map(res->
                AdminPage.builder()
                        .id(res.getId())
                        .imageBase64(getImageBase64(res.getImage()))
                        .item_description(res.getItem_description())
                        .item_name(res.getItem_name())
                        .item_price(res.getItem_price())
                        .item_rating(res.getItem_rating())
                        .build()));
        return "adminpage/mainpage.html";
    }

    @PostMapping("/save")
    public String saveData(@Valid AdminPagePojo adminPagePojo) throws IOException {
        adminPageService.saveData(adminPagePojo);
        return "redirect:/th-admin/create";
    }
    @GetMapping("edit/{id}")
    public String getUpdateData(@PathVariable Integer id, Model model){
        AdminPage adminPage =adminPageService.getByIdNotOpt(id);
        model.addAttribute("adminPagePojo",new AdminPagePojo(adminPage));
        return "adminpage/mainpage.html";
    }
    @GetMapping("/delete/{id}")
    public String getDeleteData(@PathVariable Integer id){
        adminPageService.deleteById(id);
        return "redirect:/th-admin/create";
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
