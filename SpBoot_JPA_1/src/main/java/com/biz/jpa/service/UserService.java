package com.biz.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biz.jpa.domain.UserVO;
import com.biz.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userDao;
	
	public UserVO insert(UserVO userVO) {
		
		/*
		 * repository.save(VO)
		 * JPA 환경에서는 JpaRepository를 extends 하므로 써
		 * 자동으로 기본 CRUD method를 사용할수 있다.
		 */
		UserVO vo = userDao.save(userVO);
		return vo;
	
	}

	public List<UserVO> selectAll() {

		List<UserVO> userList = userDao.findAll();
		return userList;
	
	}

	public Optional<UserVO> findById(long userId) {
 
		Optional<UserVO> userVO = userDao.findById(userId);
		return userVO;
	
	}
	
	
	
	

}
