package com.example.demo.controllers;

import com.example.demo.models.AppUsers;
import com.example.demo.repository.AppUsersRepo;
import com.example.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    AppUsersRepo appUsersRepo;

    @Autowired
    PaymentRepo paymentRepo;




    @RequestMapping("/")
    public String doHome(ModelMap model){
        model.addAttribute("list",appUsersRepo.findAll());
        return "index";
    }

    @RequestMapping("/view/{id}")
    public String doView(ModelMap model, @PathVariable("id") int id){
        model.addAttribute("user",appUsersRepo.findOne(id));
        return "view";
    }

    @RequestMapping("/delete/{id}")
    public String doDelete(ModelMap model, @PathVariable("id") int id){
        appUsersRepo.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String doHome(ModelMap model, @PathVariable("id") int id){
        model.addAttribute("user",appUsersRepo.findOne(id));
        return "edit";
    }

    @PostMapping("/addUser")
    public String doSave(@ModelAttribute("user") AppUsers appUsers){
    appUsersRepo.save(appUsers);
        return "redirect:/";
    }

}
