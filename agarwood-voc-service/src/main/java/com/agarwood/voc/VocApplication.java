package com.agarwood.voc;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@MapperScan("com.agarwood.voc.mapper")
@SpringBootApplication(scanBasePackages = "com.agarwood")
public class VocApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(VocApplication.class, args);
        MetaObjectHandler bean = context.getBean(MetaObjectHandler.class);
        System.out.println("---- bean " + bean);
    }
}
