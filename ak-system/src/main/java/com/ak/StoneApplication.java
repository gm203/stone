package com.ak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import com.ak.common.config.Global;

/**
 * 启动程序
 * 
 * @author ak
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ServletComponentScan(basePackages = { "com.ak" })
@ComponentScan(basePackages = { "com.ak" })
public class StoneApplication {
	public static void main(String[] args) {
		// System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(StoneApplication.class, args);
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n==============================================================\r\n");
		sb.append("\r\n   欢迎使用 "+ Global.getConfig("ak.name")+"  - Powered By Vean\r\n");
		sb.append("\r\n==============================================================\r\n");
		System.out.println(sb.toString());
	}
}