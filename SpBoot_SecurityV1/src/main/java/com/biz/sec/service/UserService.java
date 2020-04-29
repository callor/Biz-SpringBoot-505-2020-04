package com.biz.sec.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.UserVO;
import com.biz.sec.repository.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserDao uDao;
	private final PasswordEncoder encPasssword;
	
	public void insert(Optional<UserVO> userVO) {
		
		
		
	}

}
