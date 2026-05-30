# Smart AI 知识库管理系统

企业级 AI 知识库管理系统，基于检索增强生成（RAG）技术，提供智能文档处理和检索能力。支持多租户架构，用户可以通过自然语言查询知识库，获得基于自身文档的 AI 生成响应。

## 技术栈

### 后端
| 技术 | 版本/说明 |
|------|----------|
| 框架 | Spring Boot 3.4.2 (Java 17) |
| 数据库 | MySQL 8.0 |
| ORM | Spring Data JPA |
| 缓存 | Redis |
| 搜索引擎 | Elasticsearch 8.10.0 |
| 消息队列 | Apache Kafka |
| 文件存储 | MinIO |
| 文档解析 | Apache Tika |
| 安全认证 | Spring Security + JWT |
| AI 集成 | DeepSeek API / 本地 Ollama + 豆包 Embedding |
| 实时通信 | WebSocket |
| 依赖管理 | Maven |

### 前端
| 技术 | 说明 |
|------|------|
| 框架 | Vue 3 + TypeScript |
| 构建工具 | Vite |
| UI 组件 | Naive UI |
| 状态管理 | Pinia |
| 路由 | Vue Router |
| 样式 | UnoCSS + SCSS |

## 项目结构

```
src/main/java/com/yzq/smart/
├── SmartApplication.java         # 主应用程序入口
├── client/                       # 外部 API 客户端
├── config/                       # 配置类
├── consumer/                     # Kafka 消费者
├── controller/                   # REST API 端点
├── entity/                       # 数据实体
├── exception/                    # 自定义异常
├── handler/                      # WebSocket 处理器
├── model/                        # 领域模型
├── repository/                   # 数据访问层
├── service/                      # 业务逻辑
└── utils/                        # 工具类
```

```
frontend/
├── packages/           # 可重用模块
├── public/             # 静态资源
├── src/                # 主应用程序代码
│   ├── assets/         # SVG 图标、图片
│   ├── components/     # Vue 组件
│   ├── layouts/        # 页面布局
│   ├── router/         # 路由配置
│   ├── service/        # API 集成
│   ├── store/          # 状态管理
│   ├── views/          # 页面组件
│   └── ...             # 其他工具和配置
└── ...                 # 构建配置文件
```

## 核心功能

### 知识库管理
- 完整的文档上传与解析功能
- 支持文件分片上传和断点续传
- 标签组织管理
- 文档权限控制（公开/私有/组织标签）

### AI 驱动的 RAG 实现
- 上传的文档进行语义分块
- 调用 Embedding 模型为每个文本块生成高维向量
- 向量存储到 Elasticsearch 支持语义搜索和关键词搜索
- 根据用户查询检索相关文档
- 为 LLM 提供完整上下文，生成基于文档的准确响应

### 企业级多租户
- 通过组织标签支持多租户架构
- 每个用户可以创建或加入多个组织
- 每个组织拥有独立的知识库和文档管理
- 同一系统中管理多个团队或部门的知识库

### 实时通信
- WebSocket 技术实现用户与 AI 系统的实时交互
- 响应式聊天界面
- 知识检索和 AI 互动

## 快速启动

### 前置环境
- Java 17
- Maven 3.8.6+
- Node.js 18.20.0+
- pnpm 8.7.0+
- MySQL 8.0
- Elasticsearch 8.10.0
- MinIO
- Kafka 3.2.1
- Redis 7.0.11
- Docker（可选）

### 启动步骤

#### 1. 配置环境变量
```bash
cp .env.example .env
# 修改 .env 中的配置（数据库、Redis、Kafka、MinIO、ES 等）
```

#### 2. 启动基础服务
```bash
./infra.sh start
```

#### 3. 启动后端
```bash
mvn spring-boot:run
```

#### 4. 启动前端
```bash
cd frontend
pnpm install
pnpm run dev
```

## 架构设计

控制层处理 HTTP 请求，验证输入，管理请求/响应格式化，并将业务逻辑委托给服务层。

服务层处理业务逻辑，具有事务感知能力，能够处理跨越多个数据源的操作。

数据访问层使用 Spring Data JPA 进行数据库操作，提供对 MySQL 的 CRUD 操作。

## 许可证

MIT License
