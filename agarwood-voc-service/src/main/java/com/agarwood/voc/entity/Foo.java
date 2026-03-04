package com.agarwood.voc.entity;

import com.agarwood.components.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("foo")
public class Foo extends BaseEntity {

    @NotBlank(message = "编码不能为空")
    private String code;

    @NotBlank(message = "名称不能为空")
    private String name;
}
