package com.biz.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value="")
	public String hello() {
		
		return "redirect:/book/pagelist";
		
	}

}
