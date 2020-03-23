package com.Lph;

import com.Lph.admin.login.controller.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    //配置Ajax跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry){
        //添加映射路径
        registry.addMapping("/**")
                //放行哪些原始域
        .allowedOrigins("*")
                //是否发送Cookie信息
        .allowCredentials(true)
                //放行哪些原始域（请求方式）
        .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.OPTIONS.name())
                //放行哪些原始域（头部信息）
        .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, "accessToken", "CorrelationId", "source")
                //暴漏哪些头部信息（因为跨域访问默认不能获取全部头部信息）
        .exposedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, "accessToken", "CorrelationId", "source")
                .maxAge(4800);

    }

}
