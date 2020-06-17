create database 'byqa';

-- user
-- question
-- answer(question_id)
-- tag
-- star
-- favor
-- follow
-- comment

CREATE TABLE `user`
(
    `id`         INT(10)   NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(64) UNIQUE DEFAULT '' COMMENT '用户名',
    `password`   VARCHAR(64)        DEFAULT '' COMMENT '密码',
    `prestige`   INT(10) UNSIGNED   DEFAULT 0 COMMENT '声望',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='用户表';

CREATE TABLE `question`
(
    `id`                 INT(10)          NOT NULL AUTO_INCREMENT,
    `title`              VARCHAR(200)     NOT NULL DEFAULT '' COMMENT '标题',
    `content`            TEXT             NOT NULL COMMENT '内容',
    `views`              INT(10)          NOT NULL DEFAULT 0 COMMENT '浏览数',
    `user_id`            INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
    `selected_answer_id` INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '采纳答案ID',
    `created_at`         TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`         TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='问题表';

CREATE TABLE `answer`
(
    `id`          INT(10)          NOT NULL AUTO_INCREMENT,
    `question_id` INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '关联问题ID',
    `content`     TEXT             NOT NULL COMMENT '内容',
    `user_id`     INT(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者ID',
    `created_at`  TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  TIMESTAMP        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='回答表';
