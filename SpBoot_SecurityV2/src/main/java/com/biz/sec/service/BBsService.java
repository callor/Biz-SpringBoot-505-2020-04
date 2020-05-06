package com.biz.sec.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.BBsVO;
import com.biz.sec.repository.BBsDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BBsService {
	
	private final BBsDao bDao;
	
	public Page<BBsVO> getPageBBsList(Pageable pageable) {
		
		// 몇페이지를 요청했는가?
		int page = 0;
		if(pageable.getPageNumber() != 0)
			page = pageable.getPageNumber() - 1;
		
		// 요청한페이지에서 10개의 데이터를 추출하기 위한
		// 설정값을 만들어라
		pageable = PageRequest.of(page,10);

		// 페이지를 가져오기 위한 설정 객체(pageable)을
		// dao에게 전달하여
		// 한페이지의 데이터만 가져오도록 지시
		Page<BBsVO> pageBBsList = bDao.findAll(pageable); 

		return pageBBsList;
	
	}
	
	public List<BBsVO> getBBsList() {
		List<BBsVO> bbsList = bDao.findAll();
		return bbsList;
	}
	
	
	
	
	
	
	
	
	
	
}
