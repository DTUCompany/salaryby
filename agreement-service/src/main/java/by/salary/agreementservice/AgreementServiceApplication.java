package by.salary.agreementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AgreementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgreementServiceApplication.class, args);
	}

}
