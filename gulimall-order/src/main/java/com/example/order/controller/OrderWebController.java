package com.example.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderWebController {
    @GetMapping("/toTrade")
    public String toTrade(){
        return "confirm";
    }
}
