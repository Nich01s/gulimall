package com.atguigu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


/**
 * @Author: Nic1
 * @Date: 2022/11/7 16:58
 * @Theme:
 */

// 网关统一配置跨域
@Configuration
public class MyCorsConfiguration {

    @Bean
    public CorsWebFilter createCorsWebFilter() { //返回允许跨域的Filter
        //配置跨域信息
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();//所有与跨域配置相关的都配置在此对象
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);//是否允许跨域携带cookie

        source.registerCorsConfiguration("/**", corsConfiguration);// 1./**表示对任意路径都进行跨域配置

        return new CorsWebFilter(source);
    }
}
