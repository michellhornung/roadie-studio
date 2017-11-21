package com.hornung.roadiestudio.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
			.withUser("michell").password("michell").roles("usr").and()
			.withUser("root").password("root").roles("usr", "adm", "sup");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring()
				.antMatchers("/layout/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers("/home", "/schedule", "/calendar/new", "/report").hasRole("usr")
				.antMatchers("/user/edit", "/band/edit", "bandGenre/edit").hasRole("sup")
				.antMatchers("/home/**", "/band/**", "/bandGenre/**", "/user/**", "/schedule/**", 
						"/stock/**", "/report/**", "/room/**",
						"/rental/**", "/recording/**").hasRole("adm")
				.anyRequest()
				.authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
				
	}
}