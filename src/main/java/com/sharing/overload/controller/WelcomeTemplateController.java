package com.sharing.overload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeTemplateController {

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
}
