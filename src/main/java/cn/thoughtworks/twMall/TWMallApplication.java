package cn.thoughtworks.twMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TWMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(TWMallApplication.class, args);
	}
}
