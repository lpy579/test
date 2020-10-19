package com.example.springboot.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
	@GetMapping("favicon.ico")
    public String favicon() {
        return "forward:/asset/img/favicon.ico.png";
    }

	@GetMapping(value = "/")
    public ModelAndView home() {
		final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Welcome!");
        mv.addObject("date", SDF.format(new Date()));
        mv.setViewName("home");

        return mv;
    }
	
	@GetMapping("/starter")
    public String starter() {
        return "starter";
    }
}
