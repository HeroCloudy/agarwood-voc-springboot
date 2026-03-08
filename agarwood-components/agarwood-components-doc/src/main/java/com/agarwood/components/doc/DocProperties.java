package com.agarwood.components.doc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ConfigurationProperties(prefix = "agarwood.doc")
@Configuration
public class DocProperties {

    private Info info = new Info();
    private ExternalDocumentation externalDocs = new ExternalDocumentation();

    /**
     * 配置文档基本信息
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class Info extends io.swagger.v3.oas.models.info.Info {
        private License license = new License();
    }

    /**
     * 配置许可证信息
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class License extends io.swagger.v3.oas.models.info.License {
    }

    /**
     * 配置外部文档链接
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class ExternalDocumentation extends io.swagger.v3.oas.models.ExternalDocumentation {
    }
}
