package tujiorg.profile.configs.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	@Qualifier("db1")
	private DataSource dataSource;
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(encoder);
	}
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
		.usersByUsernameQuery("select user_id, password, '1' as enabled from user where user_id = ?")
		.authoritiesByUsernameQuery("select user_id, 'ROLE_USER' from user where user_id = ?")
		.dataSource(dataSource)
		.passwordEncoder(encoder)
		;
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/**").authenticated()
		.anyRequest().permitAll()
		.and().csrf().disable()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.usernameParameter("userID")
		.passwordParameter("password")
		.failureUrl("/login?error=-1")
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		;
		http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) {
		web
		.ignoring()
		.antMatchers("/common/js/**"
				,"/common/css/**"
				,"/common/fonts/**"
				,"/prof/js/**"
				,"/prof/css/**"
				,"/prof/fonts/**"
				)
		;
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
	}

}
