package com.biz.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.jpa.domain.UserVO;

/*
 * jpa에서 DB CRUND를 쉽게 구현하기 위하여
 * JpaRepository를 상속받고
 * Generic에 <VO, id의 type>을 지정
 */
public interface UserRepository 
			extends JpaRepository<UserVO, Long>{

}
