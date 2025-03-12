create database my_blog;

use my_blog;

# 用户表
CREATE TABLE `user` (
                        `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
                        `username` VARCHAR(50) UNIQUE NOT NULL COMMENT '用户名（登录用）',
                        `password` VARCHAR(100) NOT NULL COMMENT 'BCrypt加密密码',
                        `email` VARCHAR(100) UNIQUE NOT NULL COMMENT '邮箱（唯一标识）',
                        `avatar` VARCHAR(255) DEFAULT '/default-avatar.png' COMMENT '头像URL',
                        `role` ENUM('ADMIN', 'USER') DEFAULT 'USER' COMMENT '角色',
                        `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除（0-正常 1-删除）',
                        `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 文章表
CREATE TABLE `article` (
                           `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                           `title` VARCHAR(100) NOT NULL COMMENT '标题',
                           `content` LONGTEXT NOT NULL COMMENT 'Markdown内容',
                           `author_id` BIGINT NOT NULL COMMENT '作者ID',
                           `category_id` INT COMMENT '分类ID',
                           `view_count` INT DEFAULT 0 COMMENT '阅读量',
                           `is_deleted` TINYINT DEFAULT 0,
                           `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
                           `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           FOREIGN KEY (`author_id`) REFERENCES `user`(`id`),
                           FOREIGN KEY (`category_id`) REFERENCES `category`(`id`),
                           INDEX `idx_title` (`title`(20))  -- 前缀索引优化标题搜索
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 分类表
CREATE TABLE `category` (
                            `id` INT AUTO_INCREMENT PRIMARY KEY,
                            `name` VARCHAR(20) UNIQUE NOT NULL COMMENT '分类名称',
                            `parent_id` INT DEFAULT 0 COMMENT '父分类ID（0=根分类）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


# 标签表
CREATE TABLE `tag` (
                       `id` INT AUTO_INCREMENT PRIMARY KEY,
                       `name` VARCHAR(20) UNIQUE NOT NULL COMMENT '标签名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 文章-标签关联表
CREATE TABLE `article_tag` (
                               `article_id` BIGINT NOT NULL,
                               `tag_id` INT NOT NULL,
                               PRIMARY KEY (`article_id`, `tag_id`),
                               FOREIGN KEY (`article_id`) REFERENCES `article`(`id`),
                               FOREIGN KEY (`tag_id`) REFERENCES `tag`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 评论表
CREATE TABLE `comment` (
                           `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                           `content` TEXT NOT NULL,
                           `article_id` BIGINT NOT NULL,
                           `user_id` BIGINT NOT NULL COMMENT '评论者ID',
                           `parent_id` BIGINT DEFAULT 0 COMMENT '父评论ID（0=根评论）',
                           `is_deleted` TINYINT DEFAULT 0,
                           `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
                           `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           FOREIGN KEY (`article_id`) REFERENCES `article`(`id`),
                           FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
                           INDEX `idx_article` (`article_id`)  -- 按文章查询优化
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;