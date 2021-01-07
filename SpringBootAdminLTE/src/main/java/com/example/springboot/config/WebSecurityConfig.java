package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Spring Boot + Spring Security + Thymeleaf Form Login Example
 * https://memorynotfound.com/spring-boot-spring-security-thymeleaf-form-login-example/
 * 
 * Spring Security Custom Login Page with Thymeleaf, HTML 5 and Bootstrap 4
 * https://mail.codejava.net/frameworks/spring-boot/spring-security-custom-login-page
 * 
 * @author bobyuan
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	
	/**
	 * Authentication : User --> Roles
	 */
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = 
          PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	auth.inMemoryAuthentication()
          .withUser("user").password(encoder.encode("password")).roles("USER")
          .and()
          .withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
    }
 
    /**
     * Authorization : Role --> Access
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/examples/security/protected1*").hasRole("USER") //USER role can access
    	.antMatchers("/examples/security/protected2*").hasRole("ADMIN") //ADMIN role can access
    	.antMatchers("/", "/favico.ico", "/webjars/**", "/h2-console/**",
    			"/asset/**", "/dist/**", "/myfiles/**", "/pages/**", "/plugins/**", "/home/**", 
    			"/examples/**").permitAll() // anyone can access
        .anyRequest().authenticated() //any other request just need authentication
        .and()
            .csrf().disable()
            .headers().frameOptions().disable()
        .and()
            .rememberMe()
        .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
        .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        .and()
            .exceptionHandling()
            .accessDeniedHandler(accessDeniedHandler);
    }
}
