package com.log.drink_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Top Controller
 */
@Controller
public class MainController {

    @RequestMapping("/main")
    public String mainPage() {
        return "mainForm";
    }
}
