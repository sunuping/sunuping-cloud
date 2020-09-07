package com.sunuping;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lime
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AppOrder {
    public static void main(String[] args) {
        SpringApplication.run(AppOrder.class,args);
    }
}
