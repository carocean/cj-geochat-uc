package cj.geochat.open.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"cj.geochat.open.uc"})
@EnableDiscoveryClient
public class OpenUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenUcApplication.class, args);
    }
}
