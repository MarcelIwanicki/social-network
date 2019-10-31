package com.sharing.overload.controller;

import com.sharing.overload.entity.AppUser;
import com.sharing.overload.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class AppUserProfileController {

    @Autowired
    private AppUserService service;

    @GetMapping("/{username}")
    public String getProfile(@PathVariable String username, Model model) {
        AppUser appUser = service.findAppUserByUsername(username);
        model.addAttribute("appUserProfile", appUser);
        return "profile";
    }

}
