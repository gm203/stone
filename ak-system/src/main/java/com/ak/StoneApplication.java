package com.ak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序
 * 
 * @author ak
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ServletComponentScan(basePackages = {"com.ak"})
@ComponentScan(basePackages = {"com.ak"})
@MapperScan("com.ak.*.mapper")
public class StoneApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(StoneApplication.class, args);
    }
}