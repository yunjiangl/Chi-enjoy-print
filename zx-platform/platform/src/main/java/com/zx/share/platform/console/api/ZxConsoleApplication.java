package com.zx.share.platform.console.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fenggang
 */
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
public class ZxConsoleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ZxConsoleApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZxConsoleApplication.class);
	}
}
