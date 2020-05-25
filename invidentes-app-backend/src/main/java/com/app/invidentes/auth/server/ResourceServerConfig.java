package com.app.invidentes.auth.server;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/normatividad/**","/pqrs/**","/quienSomos/**" ).permitAll()
		.antMatchers(HttpMethod.POST,"/pqrs/**" ).permitAll()
		.antMatchers(HttpMethod.POST,"/normatividad/**","/pqrs/**","/quienSomos/**" ).hasAnyRole("Administrador", "Colaborador")
		.antMatchers(HttpMethod.PUT,"/normatividad/**","/pqrs/**","/quienSomos/**" ).hasAnyRole("Administrador", "Colaborador")
		.antMatchers(HttpMethod.DELETE,"/normatividad/**","/pqrs/**","/quienSomos/**" ).hasAnyRole("Administrador", "Colaborador")
		.antMatchers("/api/**").hasRole("Administrador")
		.antMatchers("/api/**").hasRole("Administrador")
		.anyRequest().authenticated()
		.and().cors()
		.configurationSource(corsConfigurationSource());
	}

	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://192.168.1.101:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
		
	}
	
	
	/**
	 * Metodo el cual registra los filtros y se asigna una prioridad
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	
	
}
