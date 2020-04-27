package com.biz.jpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.jpa.domain.BookVO;
import com.biz.jpa.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/book")
@Controller
public class BookController {

	private final BookService bService;
	
	// @ResponseBody
	@RequestMapping(value="/pagelist",method=RequestMethod.GET)
	public String getPageList(
			@PageableDefault Pageable page,Model model) {
		
		Page<BookVO> bookList = bService.getPageList(page); 
		model.addAttribute("bookList",bookList);
		return "bookList";
	}

}




