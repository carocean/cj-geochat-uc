package cj.geochat.proxy.uc.config;

import cj.geochat.ability.feign.annotation.EnableCjFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "cj.geochat.proxy.uc")
@EnableCjFeign
@Configuration
public class OpenFeignConfig {
}
