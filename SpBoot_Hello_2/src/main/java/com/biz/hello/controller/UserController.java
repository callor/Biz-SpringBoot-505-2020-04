package com.biz.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.hello.domain.UserVO;
import com.biz.hello.service.UserService;

@RequestMapping(value="/user")
@Controller
public class UserController {
	
	@Autowired
	UserService uService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String userList(Model model) {
		
		List<UserVO> userList = uService.getUserList();
		
		model.addAttribute("USERS",userList);
		return "user";
	}

}




