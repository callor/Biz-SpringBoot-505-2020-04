package com.biz.sec.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @ToString
@Builder

@Entity
@Table(name = "tbl_users")
public class UserVO implements UserDetails{
	private static final long serialVersionUID = 1L;

	/*
	 * 
	 * JPA의 Entity를 선언할때
	 * id 칼럼(필드변수)는 반드시 class type으로 선언하자
	 * 
	 * 그렇지 않으면 
	 * JPA의 자동완성 method가 작동되지 않는다.
	 * int => Integer
	 * long => Long
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",columnDefinition = "bigint")
	private Long id;
	
	@Column(name="username", 
			columnDefinition = "varchar(64)",
			unique = true,
			length = 64)
	private String username;
	
	// 설정하지 않으면 length = 255로 자동 설정
	private String password;
	
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	
	// java.util.Collection
	// DB에 칼럼으로 생성하지 말라
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
	
	private String email;
	private String phone;
	private String address;
	
	/*
	 * JPA에서 1:N의 관계를 설정하는 부분
	 * fetch type LAZY
	 * 두 테이블을 Join했을때
	 * 
	 * master table의 데이터를 SELECT 한 후
	 * 바로 slave table을 SELECT 하지 않고
	 * slave table의 데이터가 필요한 시점에
	 * SELECT를 수행하도록 하는 지연 옵션
	 * 
	 */
	@OneToMany(mappedBy = "userVO",
			cascade = {CascadeType.ALL},
			fetch = FetchType.LAZY)
	private Set<UserRole> userRoles;
	
	
}






