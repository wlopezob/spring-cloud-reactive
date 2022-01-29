package com.bsoftgroup.springcloudmssecurity.integration.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsUtils;

import com.bsoftgroup.springcloudmssecurity.integration.config.JwtConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUsernameAndPasswordAuthenticationFilter  extends UsernamePasswordAuthenticationFilter{
	private AuthenticationManager authManager;
	private final JwtConfig jwtConfig;
    
	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager, JwtConfig jwtConfig) {
		
		System.out.println("JwtUsernameAndPasswordAuthenticationFilter" + "url= "+jwtConfig.getUri());
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;
		
		//Configure el path de autenbtuicacion
		
		
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(), "POST"));
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("attemptAuthentication");
		
		if(CorsUtils.isPreFlightRequest(request)) {
			response.setStatus(HttpServletResponse.SC_OK);
			//return new Authentication();
		}
		
		try {
			System.out.println("1");
			//1. obteniendo datos del request
			UserCredentials creds = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);
			System.out.println("2");
			
			// 2. Creando un Objeto user que ser  usado por autmanager
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					creds.getUsername(), creds.getPassword(), Collections.emptyList());
			System.out.println("3");
			// 3. Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user.
			

			return authManager.authenticate(authToken);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Si las credenciales son correctas se activa este metodo.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		System.out.println("successfulAuthentication");
		Long now = System.currentTimeMillis();
		String token = Jwts.builder()
			.setSubject(auth.getName())	
			.claim("authorities", auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
			.setIssuedAt(new Date(now))//8:45+1
			.setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
			.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
			.compact();
		response.setContentType("application/json");
		response.addHeader("access-control-expose-headers", "Authorization");
		response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
		
	}
	
	// Clase temporal 
	private static class UserCredentials {
	    private String username, password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    
	}
}