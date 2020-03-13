package cn.uorange.orderservice.config;

import cn.uorange.oauth2client.config.OAuthResourceServerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 *
 * @Author Kumikou
 * @Date 2019/12/24
 */
@Configuration
public class ResourceServerConfig extends OAuthResourceServerConfig {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable()
                .and()
                .exceptionHandling()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers("/users/**","/login/**","/regist","/alipay/**").permitAll()
                .and()
                .authorizeRequests().antMatchers(
                "/swagger-ui.html",
                "/v2/api-docs",
                "/swagger/api-docs",
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/doc.html",
                "/webjars/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

}
