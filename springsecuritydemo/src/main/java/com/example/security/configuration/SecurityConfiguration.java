package com.example.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.inMemoryAuthentication()
		.withUser("vineet")
		.password("12345")
		.roles("user")
		.and()
		.withUser("ravi")
		.password("67890")
		.roles("admin")
		.and()
		.withUser("komal")
		.password("rawat")
		.roles("lead");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/delete").hasRole("admin")
			.antMatchers("/balance").hasRole("user")
			.antMatchers("/contact").hasAnyRole("admin","user")
			//.antMatchers("/display").hasAnyRole("admin","user")
			.antMatchers("/display").permitAll()
			.and().formLogin();
		
	}
	
	@Bean
	public PasswordEncoder getPassowordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
