package com.biz.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.GET)
	public String hello() {
	
		return "반갑습니다. 오늘은 목요일";
	
	}

}
