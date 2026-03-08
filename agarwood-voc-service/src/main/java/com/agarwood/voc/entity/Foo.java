package com.agarwood.voc.entity;

import com.agarwood.components.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Foo 实体类")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("foo")
public class Foo extends BaseEntity {

    @Schema(description = "编码")
    @NotBlank(message = "编码不能为空")
    private String code;

    @Schema(description = "名称")
    @NotBlank(message = "名称不能为空")
    private String name;
}
