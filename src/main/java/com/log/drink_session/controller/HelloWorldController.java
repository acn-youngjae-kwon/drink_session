package com.log.drink_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloWorldコントローラ。
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String hello() {
        return "helloWorldForm";
    }
}
