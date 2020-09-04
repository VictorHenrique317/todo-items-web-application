package com.controller;

import com.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    private final DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age,
                          Model model){
        model.addAttribute("welcomeUser", this.service.getHelloMessage(user));
        model.addAttribute("age", age);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        return this.service.getWelcomeMessage();
    }
}
