CREATE TABLE `users` (
  `id` char(36) NOT NULL,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` char(6) DEFAULT '' COMMENT '密码盐',
  `deletedAt` timestamp NULL DEFAULT NULL COMMENT '软删除',
  `updatedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后修改时间',
  `createdAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

INSERT INTO `users` (`id`, `username`, `password`, `salt`, `deletedAt`, `updatedAt`, `createdAt`)
VALUES
	('a89ef942-e393-4598-afc4-51a48cc977b4', 'test', '', '', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00');
