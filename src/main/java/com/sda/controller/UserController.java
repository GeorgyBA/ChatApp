package com.sda.controller;

import com.sda.model.User;
import com.sda.model.userdto.UsernameDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    @ResponseBody
    @GetMapping(value = "/api/user")
    public UsernameDto getName(@AuthenticationPrincipal User user){
        UsernameDto usernameDto=new UsernameDto();
        usernameDto.setName(user.getName());
        return usernameDto;
    }
}
