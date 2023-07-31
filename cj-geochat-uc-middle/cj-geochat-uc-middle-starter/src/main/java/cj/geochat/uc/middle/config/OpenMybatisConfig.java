package cj.geochat.uc.middle.config;

import cj.geochat.ability.mybatis.annotation.EnableCjMybatisRW;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableCjMybatisRW
@MapperScan(value = {"cj.geochat.uc.middle.**.mapper"})
@EnableTransactionManagement
@Configuration
public class OpenMybatisConfig {
}
