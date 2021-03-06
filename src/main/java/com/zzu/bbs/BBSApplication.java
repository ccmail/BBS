package com.zzu.bbs;
//启动项目的类
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = "com.zzu.bbs.mapper")
public class BBSApplication {

    public static void main(String[] args) {
        SpringApplication.run(BBSApplication.class, args);
    }



}
