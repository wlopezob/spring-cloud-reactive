package com.bsoftgroup.springcloudmssecurity.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bsoftgroup.springcloudmssecurity.integration.config.JwtConfig;
import com.bsoftgroup.springcloudmssecurity.integration.filter.JwtUsernameAndPasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()     // habilitamos cors();  
		.csrf().disable() //usamos peticiones por request sin sesiÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â³n
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()        // getion de excepciones
	        .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
	        .and()        //filter valida usuario y credenciales
		    .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))	
		    .authorizeRequests() // permit peticiones POST
		    .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll() //autenticarse
		    .anyRequest().authenticated();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure -AuthenticationManagerBuilder");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public JwtConfig jwtConfig() {
        	return new JwtConfig();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}