package com.sprint.MottuFlow.infra.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracoesSeguranca {
	
	private final FiltroTokenAcesso filtroTokenAcesso;
	
	public ConfiguracoesSeguranca( FiltroTokenAcesso filtroTokenAcesso ) {
		this.filtroTokenAcesso = filtroTokenAcesso;
	}
	
	
	@Bean
	public SecurityFilterChain filtrosSeguranca(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/css/**", "/js/**", "/assets/**").permitAll()
						.requestMatchers("/login", "/atualizar-token").permitAll()
						.requestMatchers("/api/funcionario/cadastro").hasRole( "ADMIN" )
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/", true)
						.permitAll()
				)
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login?logout")
						.permitAll()
				)
				.sessionManagement( sm -> sm.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) )
				.csrf(AbstractHttpConfigurer::disable)
				.addFilterBefore(filtroTokenAcesso, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public PasswordEncoder encriptador() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager( AuthenticationConfiguration authenticationConfiguration ) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
