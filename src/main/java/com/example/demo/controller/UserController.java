package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String welcome() {
        return "index";
    }


    @GetMapping("/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }


//    @GetMapping("/get")
//    public String get(@RequestParam(value = "id") Long id, Model model) {
//        User user = userService.findById(id);
//        if (user == null) {
//            return "errorPage";
//        }
//            model.addAttribute("user", user);
//            return "get";
//    }

    @GetMapping("/get")
    public String get(@RequestParam(value = "id") Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "errorPage";
        }
        model.addAttribute("user", user);
        return "get";
    }


    @GetMapping(value = "/form")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "form";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") Long id) {
        if (userService.findById(id) == null) {
            return "errorPage";
        }
        userService.deleteById(id);
        return "deleteCompleted";
    }
    @GetMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "changeCompleted";
    }


    @GetMapping("/completed")
    public String showChangeCompletedPage() {
        return "changeCompleted";
    }


}
