package com.liao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ProjectName JavaJvmStudyInfo
 * @Author LHB
 * @Data 2020/5/5 10:08
 * @Version 1.0
 * @Description
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}
