package com.biz.sec.config;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biz.sec.domain.UserRole;
import com.biz.sec.domain.UserVO;
import com.biz.sec.repository.BBsDao;
import com.biz.sec.repository.UserDao;
import com.biz.sec.repository.UserRoleDao;

import lombok.RequiredArgsConstructor;

/*
 * CommandLineRunner 인터페이스를 상속받은 클래스
 * spring boot에서만 사용할수 있는 특별한 클래스가 되는데
 * 
 * 프로젝트가 시작되는 시점에 어떤 코드를 자동으로 실행하고 싶을때
 * 작성하는 클래스
 */
@RequiredArgsConstructor
@Component
public class AppInit implements CommandLineRunner {

	private final UserDao uDao;
	private final UserRoleDao urDao;
	private final BBsDao bDao;

	@Override
	public void run(String... args) throws Exception {

		
		/*
		 * Optional 클래스로 vo클래스를 wrapping했을때
		 * vo에 담긴 데이터가 있으면 isPresent() 가 true가 된다
		 * 
		 * 데이터가 있으면 다음명령을 실행하지 말고
		 * return 해서 끝내라
		 * 
		 */
		Optional<UserVO> vo = uDao.findByUsername("callor");
		if(vo.isPresent()) return ;
		
		UserVO userVO = UserVO
				.builder()
				.username("callor")
				.password("12345")
				.build();
		uDao.save(userVO);

		UserRole uRole = UserRole
				.builder()
				.username("callor")
				.roleName("ADMIN")
				.build();
		urDao.save(uRole);
		
		uRole = UserRole
				.builder()
				.username("callor")
				.roleName("USER")
				.build();
		urDao.save(uRole);
	}
	
	
	
	
	
}
