后端接口设计
1. 用户认证接口:
   - POST /api/user/login - 用户登录
   -  POST /api/user/logout - 用户登出
   - POST /api/user/change-password - 修改密码
2. 文章管理分类
    - GET /api/categories - 获取所有分类
    -   GET /api/categories/{id} - 获取特定分类
    -   POST /api/categories - 创建新分类
    -   PUT /api/categories/{id} - 更新分类
    -   DELETE /api/categories/{id} - 删除分类

3. 文章管理
   - GET /api/articles - 获取所有文章（支持分页和筛选）
   - GET /api/articles/{id} - 获取特定文章
   - POST /api/articles - 创建新文章
   - PUT /api/articles/{id} - 更新文章
   - DELETE /api/articles/{id} - 删除文章

4. 评论管理
   - GET /api/articles/{id}/comments - 获取文章的所有评论
   - POST /api/articles/{id}/comments - 为文章添加评论
   - DELETE /api/comments/{id} - 删除评论
   - hgiehgeig
- gheigh