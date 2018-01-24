package com.zx.share.platform.console.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author fenggang
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zx.share.platform.common.service","com.zx.share.platform.console.api"})
public class ZxConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZxConsoleApplication.class, args);
	}
}
