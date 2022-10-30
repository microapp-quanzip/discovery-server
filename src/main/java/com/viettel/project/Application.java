package com.viettel.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@EnableEurekaServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		final Logger logger = LoggerFactory.getLogger(Application.class);
		ConfigurableApplicationContext context = springApplication.run(args);
		ConfigurableEnvironment environment = context.getEnvironment();
		String appName = environment.getProperty("spring.application.name");
		String port = environment.getProperty("server.port");
		logger.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running!\n" +
						"\t{}: http://localhost:{}\n" +
						"----------------------------------------------------------",
				appName,appName,port);
	}

}
