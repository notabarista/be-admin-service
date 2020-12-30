package org.notabarista.configuration;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {

	private final AdminServerProperties adminServer;

	public WebSecurityConfig(AdminServerProperties adminServer) {
		this.adminServer = adminServer;
	}

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		return http.securityMatcher(new NegatedServerWebExchangeMatcher(
					ServerWebExchangeMatchers.pathMatchers("/instances")))
				   .securityMatcher(new NegatedServerWebExchangeMatcher(
						   ServerWebExchangeMatchers.pathMatchers("/instances/**")))
				   .securityMatcher(new NegatedServerWebExchangeMatcher(
						   ServerWebExchangeMatchers.pathMatchers("/actuator/**")))
				   .authorizeExchange()
				   .pathMatchers("/assets/**").permitAll()
				   .anyExchange().authenticated()
				   .and().formLogin()
				   .and().csrf().disable()
				   .build();
	}
}
