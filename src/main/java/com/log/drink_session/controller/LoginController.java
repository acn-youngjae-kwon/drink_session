package com.log.drink_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Top Controller
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value="")
    public String loginPage() {
        return "login/loginForm";
    }

    @RequestMapping(value="init")
    public String login() {
        System.out.println("Login process");
        return "login/loginForm";
    }
}
