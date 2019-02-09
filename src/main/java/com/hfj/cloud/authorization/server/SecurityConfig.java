package com.hfj.cloud.authorization.server;

import java.security.Principal;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author HFJ
 *
 */
@Configuration
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {

	/**
	 * {bcrypt} - BCryptPasswordEncoder 
	 * {noop}   - NoOpPasswordEncoder 
	 * {pbkdf2} - Pbkdf2PasswordEncoder 
	 * {scrypt} - SCryptPasswordEncoder 
	 * {sha256} - StandardPasswordEncoder
	 * 
	 * For more information, check this post.
	 * 
	 * https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-encoding
	 */
	
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("Harish").password("{noop}IDontKnow").roles("USER")
			.and()
			.withUser("HFJ").password("{noop}FJH").roles("USER","ADMIN");
	}
	
	/**
	 * The getPrincipal() method normally returns UserDetails object in Spring
	 * Security, which contains all the details of currently logged in user.
	 */
	@GetMapping(value = "/user")
	Principal getUser(Principal principal) {
		return principal;
	}
	
}
