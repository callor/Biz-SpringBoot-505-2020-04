package com.biz.sec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.sec.domain.BBsVO;
import com.biz.sec.service.BBsService;

import lombok.RequiredArgsConstructor;

/*
 * REST controller
 * spring REST Full API를 만들기 위한 Controller
 * view 없는 형태로 
 * json 데이터를 보내주는 컨트롤러 역할
 */
@RequiredArgsConstructor
@RequestMapping(value="/bbs/api")
@RestController
public class BBsRestController {

	private final BBsService bService;
	
	@RequestMapping(value="/json",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3000")
	public List<BBsVO> getBBsList() {
		List<BBsVO> bbsList = bService.getBBsList();
		return bbsList;
	}

}






