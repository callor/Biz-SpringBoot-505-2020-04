package com.biz.sec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.sec.domain.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Long>{

	public List<UserRole> findByUsername(String username);
	
}




