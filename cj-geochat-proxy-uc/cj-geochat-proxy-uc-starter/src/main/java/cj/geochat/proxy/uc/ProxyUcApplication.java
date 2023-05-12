package cj.geochat.proxy.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"cj.geochat.proxy.uc"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cj.geochat.proxy.uc")
public class ProxyUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProxyUcApplication.class, args);
    }
}
