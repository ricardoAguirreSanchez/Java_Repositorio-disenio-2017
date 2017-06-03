package com.utn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }

}