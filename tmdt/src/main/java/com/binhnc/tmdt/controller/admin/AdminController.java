package com.binhnc.tmdt.controller.admin;

import com.binhnc.tmdt.model.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String index() {
        return "redirect:/admin/";
    }

    @RequestMapping("/")
    /*public String admin(Model model) {
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "admin/index";
    }*/
    public String admin() {
        return "admin/index";
    }
}
