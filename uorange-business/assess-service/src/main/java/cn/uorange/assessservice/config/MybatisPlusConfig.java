package cn.uorange.assessservice.config;

import cn.uorange.database.CommonMybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author Kumikou
 * @Date 2019/12/6
 */
@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
@MapperScan("cn.uorange.**.mapper")
public class MybatisPlusConfig extends CommonMybatisPlusConfig {
}
