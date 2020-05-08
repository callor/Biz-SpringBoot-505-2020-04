package com.biz.sec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.sec.domain.BBsVO;
import com.biz.sec.service.BBsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	@CrossOrigin(origins = "http://localhost:3000")
	public List<BBsVO> getBBsList() {
		
		List<BBsVO> bbsList = bService.getBbsList();
		return bbsList;
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public BBsVO insert(BBsVO bbsVO) {
		
		log.debug("게시판 데이터: " + bbsVO);
		bbsVO = bService.insert(bbsVO);
		return bbsVO;
	
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3000")
	public BBsVO getDetail(String bbsid) {
		
		log.debug("게시판 ID: " +  bbsid);
		long id = 0;
		try {
			id = Long.valueOf(bbsid);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Optional<BBsVO> optBBsVO = bService.findById(id);
		return optBBsVO.get();
		
	}
	
	@RequestMapping(value="/delete/{bbsid}",method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:3000")
	public String getDelete(@PathVariable("bbsid") String bbsid) {
		
		log.debug("게시판 삭제:" + bbsid);
		long id = 0;
		try {
			id = Long.valueOf(bbsid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bService.delete(id);
		
		return "OK";
		
	}

	
}







