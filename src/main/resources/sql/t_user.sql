SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `login_name` varchar(16) NOT NULL,
  `passworld` varchar(16) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `register_date` datetime NOT NULL,
  `roles` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'tom', 'tom', 'sssssvvvvvv', 'sdfsf222fsdaf2f2f', '0000-00-00 00:00:00', 'admin,leader');
