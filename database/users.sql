-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2019-05-29 08:16:43
-- 服务器版本： 5.7.22
-- PHP 版本： 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- 数据库： `aisen`
--
CREATE DATABASE IF NOT EXISTS `aisen` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `aisen`;

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(36) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `create_time`, `update_time`) VALUES
(1, 'aisen', 'aisen', '2019-05-29 16:16:09', '2019-05-29 16:16:09');
COMMIT;
