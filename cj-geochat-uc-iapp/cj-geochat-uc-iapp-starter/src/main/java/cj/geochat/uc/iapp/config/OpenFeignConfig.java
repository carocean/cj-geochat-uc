package cj.geochat.uc.iapp.config;

import cj.geochat.ability.feign.annotation.EnableCjFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "cj.geochat.uc.iapp")
@EnableCjFeign
@Configuration
public class OpenFeignConfig {
}
