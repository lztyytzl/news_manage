package com.fuxing.style;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/**
 * 注意：proxy-target-class属性值决定是基于接口的还是基于类的代理被创建。如果proxy-target-class 属性值被设置为true，
 *  那么基于类的代理将起作用（这时需要cglib库）。如果proxy-target-class属值被设置为false或者这个属性被省略，
 *  那么标准的JDK 基于接口的代理将
 */
@EnableTransactionManagement(proxyTargetClass = true)   //开启事物管理功能//启用注解事务管理，使用CGLib代理
@MapperScan("com.fuxing.style.dao")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
