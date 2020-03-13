package cn.uorange.recordservice.config;

import cn.uorange.common.webmvc.CommonJacksonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author Kumikou
 * @Date 2019/12/6
 */
@Import(CommonJacksonConfig.class)
@Configuration
public class JacksonConfig{
}
