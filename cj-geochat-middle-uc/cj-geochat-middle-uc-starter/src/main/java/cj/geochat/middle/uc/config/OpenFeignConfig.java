package cj.geochat.middle.uc.config;

import cj.geochat.ability.feign.annotation.EnableCjFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableCjFeign
@EnableFeignClients(basePackages = "cj.geochat.middle.uc")
@Configuration
public class OpenFeignConfig {
}
