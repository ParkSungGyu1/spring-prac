package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginGet(){
        return "redirect:/login-form.html";
    }

    @PostMapping("/login")
    public String loginPost(@ModelAttribute UserDto userDto,Model model){
        if(userDto.getId().equals(userDto.getPassword())){
            model.addAttribute("loginId" , userDto.getId());

        }
        return "login-result";
    }

    /*@PostMapping("/login")
    public String loginProcess(
            @RequestParam String id,
            @RequestParam String password,
            Model model
    ) {
        if (id.equals(password)) {
            model.addAttribute("loginId", id);
        }

        return "login-result";
    }*/
}
