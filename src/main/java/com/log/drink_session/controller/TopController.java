package com.log.drink_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Top Controller
 */
@Controller
@RequestMapping("/")
public class TopController {

    @RequestMapping(value="")
    public String top() {
        return "topForm";
    }
}
