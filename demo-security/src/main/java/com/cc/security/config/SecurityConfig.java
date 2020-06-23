/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cc.security.config;

import com.cc.common.util.CharsetUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Base64;

/**
 * @author Joe Grandja
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.authorizeRequests().antMatchers("/css/**", "/index").permitAll()
//                .antMatchers("/user/**").hasRole("USER").and()
//				.formLogin().loginPage("/login")
//                .failureUrl("/login-error");

        http
                .authorizeRequests().antMatchers( "/login").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login");
	}

	// @formatter:on

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(userDetails);
	}

    public static void main(String[] args) throws Exception{
	   String username = "user";
	   String password = "password";
       String Authorization = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(CharsetUtil.ISO_8859_1));
        System.out.println(Authorization);
    }
}
