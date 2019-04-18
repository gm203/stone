package com.ak.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ak.common.config.Global;
import com.google.common.base.Predicate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的接口配置
 * 
 * @author ak
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("com.ak.visualization.api");
    Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("com.ak.system.controller.tool");
	/**
	 * 创建API
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("AK Swagger2")
				// 详细定制
				.apiInfo(apiInfo()).select()
				// 指定当前包路径
//				.apis(Predicates.or(selector1,selector2))
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				// 扫描所有 .apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	/**
	 * 添加摘要信息
	 */
	private ApiInfo apiInfo() {
		// 用ApiInfoBuilder进行定制
		return new ApiInfoBuilder().title("标题：AK后台管理系统_接口文档").description("描述：用于管理项目对外的接口")
				.contact(new Contact(Global.getName(), null, null)).version("版本号:" + Global.getVersion()).build();
	}
}
