package org.sid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index() {
        return "home";
    }
    @GetMapping("/")
    public String home() {
        return "redirect:home";
    }

    @RequestMapping(value ="/403", method = {RequestMethod.GET,RequestMethod.POST})
    public String accessDenied() {
        return "403";
    }
}
