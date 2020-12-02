package org.notabarista;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableWebSecurity
@EnableAdminServer
public class AdminServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AdminServerApplication.class).web(WebApplicationType.REACTIVE).run(args);

	}

}
