package org.example.CnJava_Project;

import org.example.CnJava_Project.view.LoginView;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class CnJavaProjectApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(CnJavaProjectApplication.class).headless(false).run(args);
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
}
