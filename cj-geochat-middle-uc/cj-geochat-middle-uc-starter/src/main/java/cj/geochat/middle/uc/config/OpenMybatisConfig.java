package cj.geochat.middle.uc.config;

import cj.geochat.ability.mybatis.annotation.EnableCjMybatisRW;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCjMybatisRW
@MapperScan(value = {"cj.geochat.middle.uc.**.mapper"})
@EnableTransactionManagement
@Configuration
public class OpenMybatisConfig {
}
