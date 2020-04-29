package com.biz.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * spring security의 customizing 첫번째 단계
 * security-context.xml에 설정했던 옵션들을 지정하는 클래스
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		httpSecurity.authorizeRequests()
			.antMatchers("/hello").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user/login").permitAll()
			.antMatchers("/**").permitAll();

		httpSecurity.authorizeRequests()
			.and()
			.formLogin()
			.loginPage("/user/login")
			.failureUrl("/user/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout()
			.logoutSuccessUrl("/");
		
	}

	/*
	 * <bean><bean> 를 대신하는 java 설정
	 * 
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}







