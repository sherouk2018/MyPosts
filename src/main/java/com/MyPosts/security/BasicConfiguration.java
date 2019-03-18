package com.MyPosts.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
        auth
          .inMemoryAuthentication()
          .withUser("user")
            .password(encoder.encode("password"))
            .roles("USER")
            .and()
          .withUser("admin")
            .password(encoder.encode("admin"))
            .roles("USER", "ADMIN");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources",
                                   "/configuration/security",
                                   "/swagger-ui.html/**",
                                   "/swagger-ui.html","/swagger-ui/**",
                                   "/webjars/**"
                                   );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http .httpBasic().and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/public/signUser").permitAll()
                .antMatchers("/public/hello", "/swagger-ui/**", "/api-docs/**").permitAll()
                .antMatchers("/protected/**").authenticated()
                .and()
            .httpBasic()
                .realmName("PlcManager")
                .and()
            .csrf()
                .disable();
    }}