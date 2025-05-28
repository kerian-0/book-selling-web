package org.example.booksellingweb.controller;

import lombok.RequiredArgsConstructor;

import org.example.booksellingweb.entity.User;
import org.example.booksellingweb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String saveRegisterUser(User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.register(user);

        return "redirect:/login";
    }
    @RequestMapping("/login")
    public String login( ){
        return "login";
    }


}
