package br.unipe.pos.mobile.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SecurityExercício extends WebSecurityConfigurerAdapter {



@Override

protected void configure(HttpSecurity http) throws Exception {

http.authorizeRequests()

.antMatchers("/css/**", "/index").permitAll()

.antMatchers("/user/**").hasRole("USER")

.antMatchers("/user/**").hasRole("admin")

.antMatchers("/admin/**").hasRole("admin")


.antMatchers("/cliente/**").hasRole("USER")
.antMatchers("/admin/**").hasRole("admin")

.and().formLogin();


}



@Autowired

public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

auth.inMemoryAuthentication()

.withUser("aline").password("123").roles("USER")

.and()

.withUser("fuji").password("123").roles("admin")

.and()

.withUser("cliente").password("1818").roles("USER")
		
.and()

.withUser("admin").password("1717").roles("admin")

;

}

}
