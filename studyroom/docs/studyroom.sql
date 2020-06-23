create database `study_room`;

CREATE TABLE `user`
(
    `id`         INT(10)   NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(64) UNIQUE NOT NULL DEFAULT '' COMMENT '用户名',
    `password`   VARCHAR(64) NOT NULL       DEFAULT '' COMMENT '密码',
    `phone`      VARCHAR(20)       DEFAULT '' COMMENT '联系电话',
    `role`       TINYINT(1) NOT NULL DEFAULT 0  COMMENT '是否为管理员',
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = `utf8mb4` AUTO_INCREMENT = 20201001 COMMENT ='用户表';

CREATE TABLE `seat`
(
    `id`         INT(10)    NOT NULL AUTO_INCREMENT,
    `status`     TINYINT(1) NOT NULL DEFAULT 0 COMMENT '预定状态',
    `repair`     TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否维修',
    `created_at` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = `utf8mb4` AUTO_INCREMENT = 1 COMMENT ='座位表';

CREATE TABLE `books`
(
    `id`         INT(10)    NOT NULL AUTO_INCREMENT,
    `user_id`    INT(10)    NULL     DEFAULT 0 COMMENT '用户ID',
    `seat_id`    INT(10)    NULL     DEFAULT 0 COMMENT '座位ID',
    `created_at` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `hours`   VARCHAR(10) NOT NULL DEFAULT '' COMMENT '座位预定时长',
    `book_status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '订单状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='座位预定表';