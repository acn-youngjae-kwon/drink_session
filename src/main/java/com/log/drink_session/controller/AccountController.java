package com.log.drink_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Top Controller
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value="")
    public String loginPage() {
        return "account/registerForm";
    }

    @RequestMapping(value="init")
    public String login() {
        System.out.println("Account register process");
        return "account/registerForm";
    }
}
