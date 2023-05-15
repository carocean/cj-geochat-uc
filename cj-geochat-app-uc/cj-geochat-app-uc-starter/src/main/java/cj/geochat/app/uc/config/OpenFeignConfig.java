package cj.geochat.app.uc.config;

import cj.geochat.ability.feign.annotation.EnableCjFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "cj.geochat.app.uc")
@EnableCjFeign
@Configuration
public class OpenFeignConfig {
}
