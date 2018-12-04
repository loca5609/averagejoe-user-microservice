package edu.averagejoecoffeeco.userdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserdbApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserdbApplication.class, args);
    }
}
