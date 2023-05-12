package cj.geochat.app.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cj.geochat.app.uc"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cj.geochat.app.uc")
public class AppUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppUcApplication.class, args);
    }
}
