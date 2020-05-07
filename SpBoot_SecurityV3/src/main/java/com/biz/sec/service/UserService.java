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
	
	public void insert(Optional<UserVO> opUserVO) {
		
		UserVO userVO = opUserVO.get();
		
		// VO로 부터 password를 추출하여 BCrypt 암호화를 한 후
		// 다시 VO에 setting 하고 Dao.save()로 전달
		String strPassword = userVO.getPassword();
		String strEncPassword = encPasssword.encode(strPassword);
		
		userVO.setPassword(strEncPassword);
		userVO.setEnabled(true);
		userVO.setAccountNonExpired(true);
		userVO.setAccountNonLocked(true);
		userVO.setCredentialsNonExpired(true);
		
		UserVO retUserVO = uDao.save(userVO);

		
	}

}






