package com.agarwood.voc.entity;

import com.agarwood.components.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("foo")
public class Foo extends BaseEntity {

    private String code;
    private String name;
}
