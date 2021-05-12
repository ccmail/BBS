package com.zzu.bbs.interceptor;
/*
 * User:程成
 * Date:2021/5/12
 * Time:23:36
 * Description:拦截器
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        标明哪些地址需要进行拦截器处理
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**");
    }

}
