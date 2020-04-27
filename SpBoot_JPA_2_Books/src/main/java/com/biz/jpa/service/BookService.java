package com.biz.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biz.jpa.domain.BookVO;
import com.biz.jpa.repository.BookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service	
public class BookService {
	
	private final BookDao bookDao;

	/*
	 * spring-data 패키지의
	 * Pageable, Page, PageRequest 클래스를 사용하여
	 * pagination을 구현
	 */
	public Page<BookVO> getPageList(Pageable page) {
		
		int pageNum = 0;
		if(page.getPageNumber() == 0) pageNum = 0;
		else pageNum = page.getPageNumber() - 1;
		page = PageRequest.of(pageNum,10);
		return bookDao.findAll(page);
		
	}

}




