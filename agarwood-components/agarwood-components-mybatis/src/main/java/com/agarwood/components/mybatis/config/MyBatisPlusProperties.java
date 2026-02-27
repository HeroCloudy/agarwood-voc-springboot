package com.agarwood.components.mybatis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "agarwood.mybatis-plus")
@Data
public class MyBatisPlusProperties {

    /**
     * 是否启用分页插件
     */
    private boolean pagination = true;

    /**
     * 是否启用乐观锁插件
     */
    private boolean optimisticLocker = true;

    /**
     * 是否开启自动填充配置
     */
    private boolean autoFill = true;
}
