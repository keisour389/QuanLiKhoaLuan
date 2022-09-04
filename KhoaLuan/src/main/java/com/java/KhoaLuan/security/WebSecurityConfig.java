package com.java.KhoaLuan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.java.KhoaLuan.config.AuthoritiesConstants;

@EnableWebSecurity
@ComponentScan("com.java.KhoaLuan")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final AccountService accountService;
	
	public WebSecurityConfig(AccountService accountService) {
		this.accountService = accountService;
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(accountService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/register", "/admin").hasAuthority(AuthoritiesConstants.ADMIN)
            .antMatchers("/create-study", "/create-thesis-defense", "/mark-done", "/ministry")
            .hasAnyAuthority(AuthoritiesConstants.ADMIN, AuthoritiesConstants.MINISTRY)
            .antMatchers("/mark", "/teacher").hasAnyAuthority(AuthoritiesConstants.TEACHER)
            .antMatchers("/student").hasAnyAuthority(AuthoritiesConstants.STUDENT)
            .antMatchers("/manage-thesis-defense")
            .hasAnyAuthority(AuthoritiesConstants.TEACHER, AuthoritiesConstants.ADMIN,
            		AuthoritiesConstants.MINISTRY)
            .antMatchers("/change-password").authenticated()
            //.anyRequest().authenticated()
            .and()
            .formLogin()
            //.defaultSuccessUrl("/home")
            .permitAll()
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
            .permitAll();
    }

}
