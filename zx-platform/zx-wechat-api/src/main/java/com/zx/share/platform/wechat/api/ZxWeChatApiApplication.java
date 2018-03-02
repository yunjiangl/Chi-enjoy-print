package com.zx.share.platform.wechat.api;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = "com.zx.share.platform.wechat.mapper")
@ComponentScan(basePackages = {"com.zx.share.platform.bean","com.zx.share.platform.common.service","com.zx.share.platform.wechat"})
public class ZxWeChatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZxWeChatApiApplication.class, args);
	}


	/**
	 * 生成API文档的入口
	 */
	@Bean
	public Docket generateApi() {
		Docket docket = new Docket( DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any()).build().pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(newRule(typeResolver.resolve(
						DeferredResult.class,
						typeResolver.resolve(
								ResponseEntity.class,
								WildcardType.class
						)
				), typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false);
		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("系统接口", "wechat-api  系统接口", "0.0.1",
				"", "", "", "");
	}

	@Autowired
	private TypeResolver typeResolver;
}
