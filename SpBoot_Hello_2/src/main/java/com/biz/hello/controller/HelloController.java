package com.biz.hello.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value="",method=RequestMethod.GET)
	public String hello(Model model) {
	
		Map<String,String> user 
			= new HashMap<String,String>();
		
		user.put("name", "이몽룡");
		user.put("tel","010-222-2222");
		
		model.addAttribute("user",user);
		// resources/templates/hello.html을 읽어서
		// web으로 전송하라
		return "hello";
	}
}





