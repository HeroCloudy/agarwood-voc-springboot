# agarwood-voc-springboot 沉香 AI 问卷系统


![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-green) ![Spring AI](https://img.shields.io/badge/Spring%20AI-1.0.3-blue) ![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)

**基于 Spring Boot 3 + Spring AI 的智能问卷系统后端服务**

---

## 🎯 项目简介

**Agarwood VOC** 是一套完整的智能问卷系统，包含前后端两个独立项目：

- **后端项目**（本仓库）- 基于 Spring Boot 3 + Spring AI + Spring Security，提供强大的后端服务
    - 用户管理与权限控制
    - 问卷数据管理
    - 数据统计分析
    - AI 智能助手集成

- **前端项目** - 基于 Vue 3 + TypeScript + Nuxt 4，提供丰富的交互体验
    - 问卷编辑器（可视化拖拽设计）
    - 问卷门户（Nuxt 4 服务端渲染，SEO 友好）
    - 问卷客户端（Nuxt 4 服务端渲染，快速加载）
    - AI 智能助手

👉 前端项目地址：[wumeng-voc-vue3](https://github.com/HeroCloudy/wumeng-voc-vue3)

🌐 **在线体验地址**：[http://voc.itwumeng.com/](http://voc.itwumeng.com/)

📚 **配套教程**：后续将陆续在公众号（架构师优雅哥 youyajava）更新前后端从 0 开始开发本项目的完整完整系列文章，涵盖项目的每个细节，敬请期待！

> 💡 本套项目非常适合系统学习企业级后端开发、Spring Boot、Spring AI、Spring Security 等核心技术

---

## ✨ 项目亮点

- 🚀 **Spring AI 深度集成** - 原生集成 DeepSeek 大模型，支持流式响应，智能问卷设计助手
- 🔒 **企业级安全架构** - Spring Security + JWT + Redis 三重认证机制，完整的 RBAC 权限系统
- 📦 **模块化设计** - 多模块 Maven 项目，组件化开发，易于扩展和维护
- 🎯 **Liquibase 数据库版本管理** - 自动化数据库迁移，支持版本回滚
- 📝 **RESTful API 设计** - 统一的响应格式，Knife4j 在线文档

---

## �📖 功能特性

### 核心功能
- ✅ **用户管理** - 用户注册、登录、权限管理
- ✅ **问卷管理** - 问卷创建、编辑、发布、删除
- ✅ **问卷组件** - 支持多种题型（单选、多选、填空、文本域、标题、说明等）
- ✅ **答卷管理** - 答卷提交、查询、统计
- ✅ **数据统计** - 问卷数据的多维度统计分析，支持图表展示
- ✅ **AI 助手** - 智能问卷设计建议，自动生成问卷内容
- ✅ **用户权限** - 用户管理与基础权限控制
- ✅ **字典管理** - 系统字典数据维护

### 技术特性
- 🔐 **JWT 认证** - 无状态认证，支持 Token 刷新
- 🗄️ **数据库版本管理** - Liquibase 自动化数据库迁移
- 📡 **流式 AI 响应** - Spring AI + WebFlux 流式输出
- 🎯 **统一异常处理** - 全局异常捕获和统一响应格式
- 📊 **分页查询** - MyBatis-Plus 分页插件
- 💾 **Redis 缓存** - 用户信息缓存，提升系统性能
- 📦 **代码生成器** - 自动生成基础代码，提高开发效率

---

## 🛠 技术架构

### 后端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 17 | 编程语言 |
| Spring Boot | 3.5.7 | 应用框架 |
| Spring AI | 1.0.3 | AI 集成框架 |
| Spring Security | 6.x | 安全框架 |
| MyBatis-Plus | 3.5.12 | ORM 框架 |
| Liquibase | 4.x | 数据库版本管理 |
| Redis | - | 缓存数据库 |
| MySQL | 8.0+ | 关系型数据库 |
| MinIO | 8.5.17 | 对象存储 |
| Knife4j | 4.5.0 | API 文档 |
| Hutool | 5.8.38 | 工具类库 |
| FastJSON2 | 2.0.57 | JSON 处理 |
| Lombok | - | 代码简化 |

### 架构设计

```
┌─────────────────────────────────────────────────────────┐
│                      客户端层                             │
│         (Web / Mobile / Third-party API)                │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                    安全认证层                             │
│          (JWT Filter / Security Configuration)           │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                   Controller 层                          │
│  (VocController / SysDictController / AIController...)  │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                    Service 层                            │
│   (业务逻辑处理 / AI 集成 / 数据统计)                     │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                    Mapper 层                             │
│          (MyBatis-Plus / SQL 映射)                       │
└─────────────────────────┬───────────────────────────────┘
                          │
┌─────────────────────────▼───────────────────────────────┐
│                    数据存储层                            │
│       (MySQL / Redis / MinIO)                           │
└─────────────────────────────────────────────────────────┘
```

---

## 📁 项目结构

```
agarwood-voc-springboot/
├── agarwood-voc-service/          # 核心业务服务模块
│   └── src/main/java/com/agarwood/voc/
│       ├── ai/                  # AI 集成模块
│       │   ├── config/          # AI 配置
│       │   ├── controller/      # AI 控制器
│       │   └── tools/           # AI 工具类
│       ├── config/              # 系统配置
│       ├── controller/          # 业务控制器
│       ├── entity/              # 实体类
│       │   ├── sys/             # 系统实体
│       │   └── voc/             # 问卷实体
│       ├── mapper/              # 数据访问层
│       ├── security/            # 安全认证模块
│       │   ├── config/          # Security 配置
│       │   ├── controller/      # 认证控制器
│       │   ├── filter/          # JWT 过滤器
│       │   ├── service/         # 认证服务
│       │   └── utils/           # JWT 工具
│       ├── service/             # 业务服务层
│       └── vo/                  # 视图对象
├── agarwood-components/           # 公共组件模块
│   ├── agarwood-components-doc/   # 文档组件
│   ├── agarwood-components-minio/ # MinIO 组件
│   └── agarwood-components-mybatis/# MyBatis 组件
├── agarwood-generator/            # 代码生成器
├── agarwood-service-basic/         # 基础服务模块
│   └── src/main/java/com/agarwood/common/
│       ├── config/              # 通用配置
│       ├── exception/           # 异常处理
│       └── vo/                  # 通用 VO
├── pom.xml                      # 父 POM
└── test.http                    # API 测试文件
```

---

## 🚀 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+

### 安装步骤

1. **克隆仓库**

```bash
git clone https://github.com/HeroCloudy/agarwood-voc-springboot.git
cd agarwood-voc-springboot
```

2. **配置数据库**

创建 MySQL 数据库：

```sql
CREATE DATABASE voc DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. **修改配置文件**

编辑 `agarwood-voc-service/src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/voc?useSSL=true&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC
    username: your_username
    password: your_password
  data:
    redis:
      host: localhost
      port: 6379
  ai:
    openai:
      api-key: your_deepseek_api_key
      base-url: https://api.deepseek.com
```

4. **编译项目**

```bash
mvn clean install
```

5. **启动应用**

```bash
cd agarwood-voc-service
mvn spring-boot:run
```

或直接运行主类：

```bash
java -jar agarwood-voc-service/target/agarwood-voc-service-1.0-SNAPSHOT.jar
```

6. **访问应用**

- 应用地址：http://localhost:9001/api
- API 文档：http://localhost:9001/api/doc.html
- Swagger UI：http://localhost:9001/api/swagger-ui.html

## 📊 核心功能实现

### AI 集成

使用 Spring AI 集成 DeepSeek 大模型，支持流式响应：

```java
@GetMapping("/stream")
public Flux<String> stream(String prompt) {
    return chatClient.prompt(prompt)
            .stream()
            .content();
}
```

### JWT 认证

基于 Spring Security + JWT 的认证机制：

- JWT Filter 拦截请求
- Redis 存储 Token 和用户信息
- 支持无状态认证

### 数据统计

支持问卷数据的多维度统计：

- 问卷总答卷数统计
- 组件选项分布统计
- 支持图表数据导出

---

## 🤝 贡献指南

欢迎贡献代码！请遵循以下步骤：

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

---

## 📄 开源协议

本项目采用 [Apache License 2.0](LICENSE) 开源协议。

---

## 📮 联系方式

- 作者：yygnb
- 邮箱：hero_cloudy@126.com

---

## 🙏 致谢

感谢以下开源项目：

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring AI](https://spring.io/projects/spring-ai)
- [MyBatis-Plus](https://baomidou.com/)
- [Knife4j](https://doc.xiaominfo.com/)
- [Liquibase](https://www.liquibase.org/)

---

**如果这个项目对你有帮助，请给个 ⭐️ Star 支持一下！**

Made with ❤️ by 架构师优雅哥（youyajava）

***架构师优雅哥***

十四年程序员，呆过央企外企私企，做过前端后端架构，分享vue、Java等前后端技术和架构

在公众号上随时更新前后端技术文章及企业级实战项目。可关注公众号
- 程序员优雅哥
- 架构师优雅哥

与时间赛跑，每天都在进步！！