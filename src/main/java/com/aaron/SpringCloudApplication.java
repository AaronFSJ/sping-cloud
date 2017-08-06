package com.aaron;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


@SpringBootApplication
//@MapperScan(basePackages = "com.aaron.mapper")
@ServletComponentScan   //@ServletComponentScan使spring能够扫描到我们自己编写的servlet和filter
public class SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
}
