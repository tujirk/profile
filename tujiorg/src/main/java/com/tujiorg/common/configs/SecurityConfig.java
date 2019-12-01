package com.tujiorg.common.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	@Qualifier("db1")
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
		.usersByUsernameQuery("select user_id, password, '1' as enabled from user where user_id = ?")
		.authoritiesByUsernameQuery("select user_id, 'ROLE_USER' from user where user_id = ?")
		.dataSource(dataSource)
		.passwordEncoder(encoder)
		;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/profile/**").authenticated()
		.anyRequest().permitAll()
		.and().csrf().disable()
		.formLogin()
		//.loginPage("http://localhost:8080/tujiorg_tuji/login")
		.loginPage("https://tujiorg.com/tujiorg_tuji/login")
		.usernameParameter("userID")
		.passwordParameter("password")
		.failureUrl("/login?error=-1")
		;
	}
	
	@Override
	public void configure(WebSecurity web) {
		web
		.ignoring()
		.antMatchers("/common/js/**"
				,"/common/css/**"
				,"/common/fonts/**"
				,"/tuji/js/**"
				,"/tuji/css/**"
				,"/tuji/fonts/**"
				)
		;
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
	}
}
