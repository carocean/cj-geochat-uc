package cj.geochat.middle.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cj.geochat.middle.uc"})
@EnableDiscoveryClient
public class MiddleUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiddleUcApplication.class, args);
    }
}
