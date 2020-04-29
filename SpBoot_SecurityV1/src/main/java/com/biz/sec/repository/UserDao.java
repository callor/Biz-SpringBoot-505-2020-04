package com.biz.sec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.sec.domain.UserVO;

import jdk.nashorn.internal.runtime.FindProperty;

public interface UserDao extends JpaRepository<UserVO, Long>{
	
	/*
	 * JPA, Hibernate를 사용하면
	 * Entity 클래스를 적용하여
	 * (VO 클래스에 @Entity Annotation이 부착된 클래스)
	 * findBy*** 라는 method를 자동으로 생성해주는 기능이 있다.
	 * 
	 * Optional<VO> : method를 실행하고 
	 * 결과를 VO 단독으로 받을경우
	 * 이후 코드에서 VO의 속성(getter)을 조회하거나 
	 * method(toString()) 조회할경우 NullPointerException이
	 * 발생하게 되는데 Exception이 발생하지 않도록
	 * 도와주는 도우미 클래서
	 * 
	 */
	public Optional<UserVO> findByUsername(String username);
	
	 
	
}



