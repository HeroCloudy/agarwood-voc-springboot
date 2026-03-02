package com.agarwood.components.mybatis.handler;

import com.agarwood.components.mybatis.config.MyBatisPlusProperties;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AgMetaObjectHandler implements MetaObjectHandler {

    private final MyBatisPlusProperties properties;

    private String getCurrentUserId() {
        return "SYS_DEFAULT";
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        if (properties.isAutoFill()) {
            this.strictInsertFill(metaObject, "isDeleted", Integer.class, 0);
            this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, "createBy", String.class, getCurrentUserId());
            this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
            this.strictInsertFill(metaObject, "updateBy", String.class, getCurrentUserId());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (properties.isAutoFill()) {
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
            this.strictUpdateFill(metaObject, "updateBy", String.class, getCurrentUserId());
        }
    }
}
