package com.biz.sec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.sec.domain.BBsVO;
import com.biz.sec.service.BBsService;

import lombok.RequiredArgsConstructor;

/*
 * RestController는 Return type에 관계 없이
 * 모든 값을 json 객체형으로 web에 되돌린다.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value="/bbs/api")
public class BBsRestController {

	private final BBsService bService;

	@RequestMapping(value="/json",method=RequestMethod.GET)
	public List<BBsVO> getBBsList() {
		
		List<BBsVO> bbsList = bService.getBbsList();
		return bbsList;
		
	}
	
}







