package com.biz.sec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Builder

@Entity
@Table(name = "tbl_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",columnDefinition = "bigint")
	private Long id;
	
	@Column(name="username", 
			columnDefinition = "varchar(64)",
			length = 64)
	private String username;
	private String roleName;
	
	/*
	 * JPA에서 1:N 관계를 설정하려면
	 * 두 연결된 클래스에 각각 @OneToMany, @ManyToOne을 설정해준다.
	 */
	@ManyToOne
	@JoinColumn(name="username",
		referencedColumnName = "username",
		insertable = false,
		updatable = false)
	private UserVO userVO;
		
}




