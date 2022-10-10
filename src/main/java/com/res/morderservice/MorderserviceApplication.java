package com.res.morderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MorderserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorderserviceApplication.class, args);
    }

}
