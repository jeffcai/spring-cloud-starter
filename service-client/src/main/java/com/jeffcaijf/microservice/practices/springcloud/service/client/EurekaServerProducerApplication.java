package com.jeffcaijf.microservice.practices.springcloud.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServerProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerProducerApplication.class, args);
    }

}
