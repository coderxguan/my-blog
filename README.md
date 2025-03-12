# 一、项目概述
## 核心目标
构建一个集个人品牌展示、技术博客输出、项目作品集于一体的全栈网站，采用前后端分离架构实现模块化开发

## 用户角色
- 访客：浏览内容、查看作品、阅读博客
- 管理员：内容管理（文章/项目发布、评论审核）

# 二、技术架构设计
- 前端：Vue3 + Element Plus + Axios + ECharts 
- 后端：Spring Boot 3.x + MyBatis Plus + JWT + Redis
- 数据库：MySQL（核心业务） + Redis（缓存）
- 部署：Docker Compose + Nginx