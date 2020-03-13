package cn.uorange.ribbon;


import cn.uorange.ribbon.config.FeignInterceptorConfig;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(FeignInterceptorConfig.class)
public class FeignAutoConfigure {
    /**
     * Feign 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
