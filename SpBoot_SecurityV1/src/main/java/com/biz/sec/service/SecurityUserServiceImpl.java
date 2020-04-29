package com.biz.sec.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.UserRole;
import com.biz.sec.domain.UserVO;
import com.biz.sec.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SecurityUserServiceImpl implements UserDetailsService{

	private final UserDao uDao;
	private final PasswordEncoder passwordEncoder ;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.debug("UserName:" + username);
		
		Optional<UserVO> userVO = uDao.findByUsername(username);
		log.debug(userVO.toString());
		if( !userVO.isPresent() ) {
			throw new UsernameNotFoundException(
					username + " 정보를 찾을수 없음"
			);
		}
		
		// Optional<VO> 형식의 데이터에서 VO를 추출하기 위해서는
		// .get() method를 실행해준다.
		Collection<GrantedAuthority> authorities
			= this.getUserAuthority(userVO.get().getUserRoles());

		UserVO userDetailsVO = userVO.get();
		userDetailsVO.setAuthorities(authorities);
		return userDetailsVO;
	
	}
	
		
	
	/*
	 * DB에 문자열로 저장되어 있는 권한 정보를
	 * GrantedAuthority 형식으로 변환하는 method
	 * 
	 */
	private Collection<GrantedAuthority> 
				getUserAuthority(Set<UserRole> userRoles) {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(UserRole uRole : userRoles) {
			authorities.add(
					new SimpleGrantedAuthority(uRole.getRoleName())
			);
		}
		return authorities;
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}
	
	
}






