package org.example.CnJava_Project.config.db;


import org.example.CnJava_Project.config.AES256;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
	@Value("${db.datasource.driver-class-name}")
	private String driverClassname;
	@Value("${db.datasource.url}")
	private String url;
	@Value("${db.datasource.username}")
	private String username;
	@Value("${db.datasource.password}")
	private String password;
	String secretKey = "MySecretKey";
	String salt = "MySalt";
	@Bean
	public DataSource dataSource(){

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverClassname);
		dataSourceBuilder.url(AES256.decrypt(url, secretKey, salt));
		dataSourceBuilder.username(AES256.decrypt(username, secretKey, salt));
		dataSourceBuilder.password(AES256.decrypt(password, secretKey, salt));

		return dataSourceBuilder.build();
	}
}
