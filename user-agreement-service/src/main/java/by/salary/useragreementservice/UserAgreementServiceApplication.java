package by.salary.useragreementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAgreementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAgreementServiceApplication.class, args);
    }

}
