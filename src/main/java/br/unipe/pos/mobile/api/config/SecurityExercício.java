package br.unipe.pos.mobile.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityExercício extends WebSecurityConfigurerAdapter {



	
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/api/v1.0/alunos").hasAnyRole("ALUNO")
		.antMatchers("/api/v1.0/diretores").hasAnyRole("DIRETORA")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin().permitAll().and().logout().permitAll();
		
	}



@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
		PasswordEncoder encoder =PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
		auth.inMemoryAuthentication()
		
		.withUser("aluno").password(encoder.encode("123")).roles("ALUNO")
		.and()
		.withUser("aline").password(encoder.encode("1234")).roles("DIRETORA");

	}

}
