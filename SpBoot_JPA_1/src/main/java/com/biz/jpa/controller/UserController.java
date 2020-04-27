package com.biz.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.jpa.domain.UserVO;
import com.biz.jpa.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(value="/user")
@Controller
public class UserController {
	
	private final UserService uService;
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String user(Model model) {
		model.addAttribute("user", new UserVO());
		return "userform";
	}

	/*
	 * spring Boot에서는 @ResponseBody를 설정하면
	 * 별다른 Dependency 설정 없이 자동으로
	 * VO 등 클래스를 return 할수 있다.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String user(UserVO userVO) {
		log.debug(userVO.toString());
		
		UserVO vo = uService.save(userVO);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String userList(Model model) {
		
		List<UserVO> userList = uService.selectAll();
		
		model.addAttribute("userList",userList);
		return "layout";
	
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id, Model model) {
		
		long userId = 0;
		try {
			userId = Long.valueOf(id);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		Optional<UserVO> userVO = uService.findById(userId);
		model.addAttribute("user",userVO.get());
		return "userform";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(UserVO userVO) {
		UserVO vo = uService.save(userVO);
		return "redirect:/user/list";
	}

	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(String id) {
		
		long userId = 0;
		try {
			userId = Long.valueOf(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		uService.delete(userId);
		return "redirect:/user/list";
	
	}
}




