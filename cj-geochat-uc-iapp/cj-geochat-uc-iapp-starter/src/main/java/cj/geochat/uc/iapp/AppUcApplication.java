package cj.geochat.uc.iapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cj.geochat.uc.iapp"})
public class AppUcApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppUcApplication.class, args);
    }
}
