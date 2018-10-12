#
# Structure for table "rc_data_dictionary"
#

DROP TABLE IF EXISTS `rc_data_dictionary`;
CREATE TABLE `rc_data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `field_name` varchar(255) NOT NULL COMMENT '字段名',
  `field_code` varchar(255) NOT NULL COMMENT '字段CODE',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=474 DEFAULT CHARSET=utf8 COMMENT='数据字典';

#
# Structure for table "rc_data_dictionary_list"
#

DROP TABLE IF EXISTS `rc_data_dictionary_list`;
CREATE TABLE `rc_data_dictionary_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `field_code` varchar(255) NOT NULL COMMENT '字段CODE',
  `field_key` varchar(255) NOT NULL COMMENT '字段KEY',
  `field_value` varchar(255) NOT NULL COMMENT '字段VALUE',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '字段排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='数据字典明细表';

#
# Structure for table "rc_email_account_info"
#

DROP TABLE IF EXISTS `rc_email_account_info`;
CREATE TABLE `rc_email_account_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `from_user` varchar(255) NOT NULL COMMENT '发件人',
  `passwd` varchar(255) NOT NULL COMMENT '密码',
  `host` varchar(255) NOT NULL COMMENT 'HOST',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='邮件发送账号信息表';


#
# Structure for table "rc_email_info"
#

DROP TABLE IF EXISTS `rc_email_info`;
CREATE TABLE `rc_email_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `to_user` char(18) DEFAULT NULL,
  `from_user` char(21) DEFAULT NULL,
  `title` varchar(225) DEFAULT NULL,
  `subject` varchar(225) DEFAULT NULL,
  `content` varchar(5120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=488 DEFAULT CHARSET=utf8 COMMENT='邮件信息表';

#
# Structure for table "rc_permission"
#

DROP TABLE IF EXISTS `rc_permission`;
CREATE TABLE `rc_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `permissions_name` varchar(20) NOT NULL COMMENT '权限名',
  `permissions_value` varchar(20) NOT NULL COMMENT '权限值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

#
# Data for table "rc_permission"
#

INSERT INTO `rc_permission` VALUES (1,'1','2016-11-23 16:34:28','2016-12-15 16:41:28','管理员查看','admin:read'),(2,'1','2016-11-23 16:35:47','2016-12-15 16:41:12','管理员添加','admin:insert'),(3,'1','2016-11-23 16:36:23','2016-12-15 16:41:00','管理员删除','admin:delete'),(4,'1','2016-11-23 16:36:55','2016-12-15 16:40:46','管理员修改','admin:update'),(5,'1','2016-11-23 16:37:54','2016-11-23 16:37:54','用户修改','user:update'),(6,'1','2016-11-23 16:38:22','2016-11-23 16:38:22','用户查看','user:read'),(7,'1','2016-11-23 16:38:45','2016-12-21 10:56:56','用户添加','user:insert'),(8,'1','2016-11-23 16:39:25','2016-11-23 16:39:25','用户删除','user:delete'),(10,'1','2016-12-15 16:07:53','2016-12-15 16:07:53','超级管理员删除','super:delete'),(11,'1','2016-12-15 16:08:16','2016-12-15 16:08:16','超级管理员查看','super:read'),(12,'1','2016-12-15 16:08:47','2016-12-21 11:33:03','超级管理员修改','super:update'),(13,'1','2016-12-15 16:09:14','2016-12-21 11:32:51','超级管理员添加','super:insert');

#
# Structure for table "rc_role"
#

DROP TABLE IF EXISTS `rc_role`;
CREATE TABLE `rc_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `role_name` varchar(40) NOT NULL DEFAULT '' COMMENT '角色名',
  `role_value` varchar(20) NOT NULL DEFAULT '' COMMENT '角色值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

#
# Data for table "rc_role"
#

INSERT INTO `rc_role` VALUES (1,'1','2016-11-23 16:34:28','2016-12-15 16:37:24','管理员','admin'),(2,'1','2016-11-23 16:34:28','2016-12-15 17:16:08','普通用户','user'),(6,'1','2016-12-15 14:43:51','2016-12-22 14:49:05','高级管理员','advanced'),(7,'1','2016-12-15 16:15:56','2016-12-22 09:54:08','超级管理员','super');

#
# Structure for table "rc_role_permissions"
#

DROP TABLE IF EXISTS `rc_role_permissions`;
CREATE TABLE `rc_role_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色',
  `permission_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=629 DEFAULT CHARSET=utf8;

#
# Data for table "rc_role_permissions"
#

INSERT INTO `rc_role_permissions` VALUES (137,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,8),(138,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,7),(139,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,6),(140,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,5),(141,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,4),(142,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,3),(143,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,2),(144,'1','2016-12-15 16:37:24','2016-12-15 16:37:24',1,1),(164,'1','2016-12-15 17:16:08','2016-12-15 17:16:08',2,8),(165,'1','2016-12-15 17:16:08','2016-12-15 17:16:08',2,7),(166,'1','2016-12-15 17:16:08','2016-12-15 17:16:08',2,6),(167,'1','2016-12-15 17:16:08','2016-12-15 17:16:08',2,5),(587,'1','2016-12-22 09:54:07','2016-12-22 09:54:07',7,13),(588,'1','2016-12-22 09:54:07','2016-12-22 09:54:07',7,12),(589,'1','2016-12-22 09:54:07','2016-12-22 09:54:07',7,11),(590,'1','2016-12-22 09:54:07','2016-12-22 09:54:07',7,10),(591,'1','2016-12-22 09:54:07','2016-12-22 09:54:07',7,8),(592,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,7),(593,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,6),(594,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,5),(595,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,4),(596,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,3),(597,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,2),(598,'1','2016-12-22 09:54:08','2016-12-22 09:54:08',7,1),(620,'1','2016-12-22 14:49:04','2016-12-22 14:49:04',6,11),(621,'1','2016-12-22 14:49:04','2016-12-22 14:49:04',6,8),(622,'1','2016-12-22 14:49:04','2016-12-22 14:49:04',6,7),(623,'1','2016-12-22 14:49:04','2016-12-22 14:49:04',6,6),(624,'1','2016-12-22 14:49:04','2016-12-22 14:49:04',6,5),(625,'1','2016-12-22 14:49:05','2016-12-22 14:49:05',6,4),(626,'1','2016-12-22 14:49:05','2016-12-22 14:49:05',6,3),(627,'1','2016-12-22 14:49:05','2016-12-22 14:49:05',6,2),(628,'1','2016-12-22 14:49:05','2016-12-22 14:49:05',6,1);

#
# Structure for table "rc_user"
#

DROP TABLE IF EXISTS `rc_user`;
CREATE TABLE `rc_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `user_no` varchar(40) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `sex` int(1) DEFAULT '1' COMMENT '性别(0为女 1为男)',
  `view_type` varchar(20) NOT NULL DEFAULT '' COMMENT '首页视图',
  `data_scope` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '数据范围',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `rc_company`;
CREATE TABLE `rc_company` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` VARCHAR(60) NOT NULL COMMENT '系统名称',
  `number` VARCHAR(20) NOT NULL COMMENT '系统编码',
  `type` VARCHAR(30) not null COMMENT '公司类型',
  `desc` VARCHAR(100) not null COMMENT '备注'
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

#
# Data for table "rc_user"
#

INSERT INTO `rc_user` VALUES (1,'1','2016-11-23 16:20:17','2016-12-15 16:34:50','admin','YWRtaW4=','管理员',1),(2,'1','2016-11-23 16:21:39','2016-12-22 10:55:54','user','dXNlcg==','普通用户',1),(5,'1','2016-12-15 16:16:35','2016-12-20 11:54:11','super','c3VwZXI=','超级管理员',1);

#
# Structure for table "rc_user_login_logs"
#

DROP TABLE IF EXISTS `rc_user_login_logs`;
CREATE TABLE `rc_user_login_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `roncoo_no` varchar(255) NOT NULL COMMENT '账号',
  `login_ip` varchar(255) NOT NULL COMMENT '登录IP',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息记录表';

#
# Data for table "rc_user_login_logs"
#


#
# Structure for table "rc_user_role"
#

DROP TABLE IF EXISTS `rc_user_role`;
CREATE TABLE `rc_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status_id` char(1) NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '账号',
  `roles_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

#
# Data for table "rc_user_role"
#

INSERT INTO `rc_user_role` VALUES (48,'1','2016-12-15 16:34:50','2016-12-15 16:34:50',1,6),(49,'1','2016-12-15 16:34:50','2016-12-15 16:34:50',1,2),(50,'1','2016-12-15 16:34:50','2016-12-15 16:34:50',1,1),(74,'1','2016-12-20 11:54:11','2016-12-20 11:54:11',5,7),(75,'1','2016-12-20 11:54:11','2016-12-20 11:54:11',5,6),(76,'1','2016-12-20 11:54:11','2016-12-20 11:54:11',5,2),(77,'1','2016-12-20 11:54:11','2016-12-20 11:54:11',5,1),(119,'1','2016-12-22 10:55:54','2016-12-22 10:55:54',2,2);

#
#财务报表导入(主表)
#
DROP TABLE IF EXISTS `t_finance_main`;
CREATE TABLE `t_finance_main` (
  `fid` BIGINT NOT NULL,
  `fcreator` BIGINT NOT NULL COMMENT '创建人',
  `fcreatime` TIMESTAMP NOT NULL COMMENT '创建时间',
  `fupdator` BIGINT NULL COMMENT '修改人',
  `fupdatime` TIMESTAMP NULL COMMENT '修改时间',
  `fcompany_number` VARCHAR(45) NOT NULL COMMENT '公司编码',
  `fcompany_name` VARCHAR(45) NULL COMMENT '公司名称',
  `fstatus` VARCHAR(45) NOT NULL COMMENT '状态,0未生效1已生效,2已删除',
  `fyear_month` VARCHAR(45) NOT NULL COMMENT '期间',
  `freport` VARCHAR(45) NOT NULL COMMENT '报表名称',
  `freport_number` VARCHAR(45) NOT NULL COMMENT '报表编码',
  `fdescription` VARCHAR(255) NULL,
  `ffinance_chage` VARCHAR(45) NULL,
  `funit_chage` VARCHAR(45) NULL,
  `fbizdate` DATE NULL,
  PRIMARY KEY (`fid`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

#
#财务_资产负债表
#
DROP TABLE IF EXISTS `t_finance_balance`;
CREATE TABLE `t_finance_balance` (
  `fid` BIGINT NOT NULL,
  `fhead_id` BIGINT NOT NULL COMMENT '表头ID',
  `frow_index1` INT NULL COMMENT '行次',
  `fproject1` VARCHAR(100) NULL COMMENT '项目1',
  `ffinal_amount1` DOUBLE NULL COMMENT '期末金额1',
  `fbeginning_amount1` DOUBLE NULL COMMENT '年初金额1',
  `fproject2` VARCHAR(100) NULL COMMENT '项目2',
  `frow_index2` INT NULL COMMENT '行次2',
  `ffinal_amount2` DOUBLE NULL COMMENT '期末金额2',
  `fbeginning_amount2` DOUBLE NULL COMMENT '年初金额2',
  `fstatus` VARCHAR(10) NOT NULL DEFAULT 0 COMMENT '状态0正常',
  `fsheet_row_number` INT NULL COMMENT 'excel行号',
  PRIMARY KEY (`fid`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8
  COMMENT = '资产负债表';

DROP TABLE IF EXISTS t_sys_org;
CREATE TABLE t_sys_org
(
  fid BIGINT PRIMARY KEY AUTO_INCREMENT,
  fcode VARCHAR(50) NOT NULL COMMENT '组织编码',
  fname VARCHAR(50) NOT NULL COMMENT '组织名称',
  flong_code VARCHAR(300) COMMENT '组织长编码',
  fparent_id VARCHAR(50) COMMENT '上级组织ID',
  fparent_name VARCHAR(50),
  fpos INT DEFAULT 999 NOT NULL COMMENT '组织排序号',
  fcatalogy VARCHAR(50) COMMENT '组织分类',
  fendflag INT DEFAULT 0 NOT NULL COMMENT '部门结束标记0有下级1无下级',
  fstatus VARCHAR(10) DEFAULT '0' NOT NULL COMMENT '组织状态0正常1停用',
  fview_id BIGINT NOT NULL COMMENT '默认视图',
  fdescn VARCHAR(255) COMMENT '备注'
);
CREATE UNIQUE INDEX t_sys_org_fcode_uindex ON roncoo_adminlte.t_sys_org (fcode);
ALTER TABLE roncoo_adminlte.t_sys_org COMMENT = '组织结构';


DROP TABLE IF EXISTS t_sys_view;
CREATE TABLE t_sys_view
(
  fid BIGINT PRIMARY KEY AUTO_INCREMENT,
  fpage VARCHAR(20) NOT NULL COMMENT '视图地址',
  fname VARCHAR(50) NOT NULL COMMENT '视图名称'
);
CREATE UNIQUE INDEX t_sys_view_fpage_uindex ON roncoo_adminlte.t_sys_view (fpage);
ALTER TABLE roncoo_adminlte.t_sys_view COMMENT = '数据视图';