/*
Navicat MySQL Data Transfer

Source Server         : 10.45.44.188
Source Server Version : 50622
Source Host           : 10.45.44.188:3306
Source Database       : webframework

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-10-09 15:04:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `am_organization`
-- ----------------------------
DROP TABLE IF EXISTS `am_organization`;
CREATE TABLE `am_organization` (
  `organization_id` int(11) NOT NULL COMMENT '组织ID',
  `pid` int(11) DEFAULT NULL COMMENT '父组织ID',
  `org_name` varchar(100) DEFAULT NULL COMMENT '组织名称',
  `is_root` char(1) DEFAULT NULL COMMENT '是否根节点',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `level` int(11) DEFAULT NULL COMMENT '层次',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`organization_id`),
  KEY `ind_uw_organization_org_name` (`org_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of am_organization
-- ----------------------------
INSERT INTO `am_organization` VALUES ('1', '0', '销售部', null, null, '1', null, '1');
INSERT INTO `am_organization` VALUES ('2', '0', '人事部', null, null, '1', null, '1');
INSERT INTO `am_organization` VALUES ('3', '0', '科技部', null, null, '1', null, '1');
INSERT INTO `am_organization` VALUES ('4', '1', '销售部1科', null, null, '2', null, '1');
INSERT INTO `am_organization` VALUES ('5', '1', '销售部2科', null, null, '2', null, '1');
INSERT INTO `am_organization` VALUES ('6', '2', '人事部1科', null, null, '2', null, '1');
INSERT INTO `am_organization` VALUES ('7', '4', '4', null, null, '3', null, '1');
INSERT INTO `am_organization` VALUES ('8', '5', '5', null, null, '3', null, '1');
INSERT INTO `am_organization` VALUES ('9', '6', '6', null, null, '3', null, '1');
INSERT INTO `am_organization` VALUES ('10', '7', '7', null, null, '3', null, '1');
INSERT INTO `am_organization` VALUES ('11', '10', '11', null, null, '4', null, '1');
INSERT INTO `am_organization` VALUES ('12', '3', '12', null, null, '2', null, '1');
INSERT INTO `am_organization` VALUES ('13', '3', '13', null, null, '2', null, '1');

-- ----------------------------
-- Table structure for `am_role`
-- ----------------------------
DROP TABLE IF EXISTS `am_role`;
CREATE TABLE `am_role` (
  `ROLE_ID` int(11) NOT NULL COMMENT '主键',
  `ROLE_NAME` varchar(60) NOT NULL COMMENT '角色名称',
  `STATE_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_LOCKED` char(1) DEFAULT NULL COMMENT '是否锁定',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `COMMENTS` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of am_role
-- ----------------------------
INSERT INTO `am_role` VALUES ('1', '系统管理员', '2014-11-12 17:27:44', null, '2014-11-12 17:27:44', '是范德萨发撒法萨芬撒');

-- ----------------------------
-- Table structure for `am_user`
-- ----------------------------
DROP TABLE IF EXISTS `am_user`;
CREATE TABLE `am_user` (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `USER_NAME` varchar(200) NOT NULL COMMENT '用户名',
  `NICK_NAME` varchar(200) DEFAULT NULL COMMENT '用户昵称',
  `USER_CODE` varchar(200) DEFAULT NULL,
  `TELEPHONE` varchar(20) DEFAULT NULL COMMENT '电话',
  `EMAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `AGE` int(11) DEFAULT NULL COMMENT '年龄',
  `STATE` char(1) NOT NULL COMMENT '状态 A：有效  X：失效',
  `CREATED_DATE` datetime NOT NULL COMMENT '创建日期',
  `TEST_NUMBER_ONE` decimal(16,5) DEFAULT NULL COMMENT 'TEST_NUMBER_ONE',
  `TEST_NUMBER_TWO` decimal(9,0) DEFAULT NULL COMMENT 'TEST_NUMBER_TWO',
  `TEST_DOUBLE_ONE` double(12,6) DEFAULT NULL,
  `TEST_DOUBLE_TWO` double DEFAULT NULL,
  `PHOTO` blob COMMENT '头像',
  `TEST_TEXT` text,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户\r\n';

-- ----------------------------
-- Records of am_user
-- ----------------------------
INSERT INTO `am_user` VALUES ('1', '张三aa', '昵称sss1', '1', '随碟附送发送方', 'ssss@qq.com', '1', '22', 'A', '2014-11-12 00:00:00', '1.00000', '1', '1.000000', '1', 0x31, '1');
INSERT INTO `am_user` VALUES ('3', '333', '33333', null, '333333', 'cccc@qq.com', null, '23', 'A', '2014-11-12 17:29:00', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('4', '444sadasfdas', '4444', 'www', '44444', 'cccc@qq.com', null, '23', 'A', '2014-11-12 17:29:00', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('5', '555', '5555', null, '555555', 'cccc@qq.com', null, '23', 'A', '2014-11-12 17:29:00', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('6', '666', '66666', null, '6666666', 'cccc@qq.com', null, '23', 'A', '2014-11-12 17:29:00', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('7', '77', '777', null, '随碟附送发送方', 'ssss@qq.com', null, '22', 'A', '2014-11-12 17:27:44', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('8', '88', '888', null, '随碟附送发送方', 'ssss@qq.com', null, '22', 'A', '2014-11-12 17:27:44', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('9', '999', '999', null, '随碟附送发送方', 'ssss@qq.com', null, '22', 'A', '2014-11-12 17:27:44', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('10', '101111', '10111111', null, '随碟附送发送方111111', 'dddddd@qq.com', null, '20', 'X', '2014-11-12 17:27:44', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('11', '111111', '11111', 'userCode', '随碟附送发送方', 'ssss@qq.com', '', '22', 'A', '2014-11-12 17:27:44', null, null, null, null, '', '');
INSERT INTO `am_user` VALUES ('12', '12', '12', null, '随碟附送发送方', 'ssss@qq.com', null, '22', 'A', '2014-11-12 17:27:44', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('13', '13', '13', null, '随碟附送发送方', 'ssss@qq.com', null, '22', 'A', '2014-11-12 17:27:44', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('21', '神烦大叔法萨芬', null, null, null, 'dddddd', null, '20', 'A', '2014-12-08 15:47:52', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('30', '测试0', '', null, '', 'dddddd0@qq.com', null, '20', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('31', '测试1', null, null, null, 'dddddd1', null, '21', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('32', '测试2', null, null, null, 'dddddd2', null, '22', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('33', '测试3', null, null, null, 'dddddd3', null, '23', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('34', '测试4', null, null, null, 'dddddd4', null, '24', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('35', '测试5', null, null, null, 'dddddd5', null, '25', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('36', '测试6', null, null, null, 'dddddd6', null, '26', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('37', '测试7', null, null, null, 'dddddd7', null, '27', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('38', '测试8', null, null, null, 'dddddd8', null, '28', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('39', '测试9', null, null, null, 'dddddd9', null, '29', 'A', '2014-11-25 17:40:19', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40', '用户们么么么么111', null, null, null, 'dddddd', null, '20', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('41', '测试0', null, null, null, 'dddddd0', null, '20', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('42', '测试1', null, null, null, 'dddddd1', null, '21', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('43', '测试2', null, null, null, 'dddddd2', null, '22', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('44', '测试3', null, null, null, 'dddddd3', null, '23', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45', '测试4', null, null, null, 'dddddd4', null, '24', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('46', '测试5', null, null, null, 'dddddd5', null, '25', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('47', '测试6', null, null, null, 'dddddd6', null, '26', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('48', '测试7', null, null, null, 'dddddd7', null, '27', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('49', '测试8', null, null, null, 'dddddd8', null, '28', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('50', '测试9', null, null, null, 'dddddd9', null, '29', 'A', '2014-12-02 17:06:36', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('51', '用户们么么么么', null, null, null, 'dddddd', null, '20', 'A', '2014-12-02 17:06:37', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40001', 'pageInc', '', null, '', '', null, null, '', '2014-12-04 17:06:18', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40002', 'aaaaaaaaaaaaaaaaa', '', null, '', '', null, null, '', '2014-12-04 17:09:57', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40009', 'aaa', '', null, '', '', null, null, '', '2014-12-04 17:23:05', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40010', 'bbb', '', null, '', '', null, null, '', '2014-12-04 17:23:11', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40016', '用户们么么么么111', null, null, null, 'dddddd', null, '20', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40017', '测试0', null, null, null, 'dddddd0', null, '20', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40018', '测试1', null, null, null, 'dddddd1', null, '21', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40019', '测试2', null, null, null, 'dddddd2', null, '22', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40020', '测试3', null, null, null, 'dddddd3', null, '23', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40021', '测试4', null, null, null, 'dddddd4', null, '24', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40022', '测试5', null, null, null, 'dddddd5', null, '25', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40023', '测试6', null, null, null, 'dddddd6', null, '26', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40024', '测试7', null, null, null, 'dddddd7', null, '27', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40025', '测试8', null, null, null, 'dddddd8', null, '28', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40026', '测试9', null, null, null, 'dddddd9', null, '29', 'A', '2014-12-08 15:46:06', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('40027', '用户们么么么么', null, null, null, 'dddddd', null, '20', 'A', '2014-12-08 15:46:07', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45895', '测试0', null, null, null, 'dddddd0', null, '20', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45896', '测试1', null, null, null, 'dddddd1', null, '21', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45898', '测试2', null, null, null, 'dddddd2', null, '22', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45900', '测试3', null, null, null, 'dddddd3', null, '23', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45902', '测试4', null, null, null, 'dddddd4', null, '24', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45904', '测试5', null, null, null, 'dddddd5', null, '25', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45907', '测试6', null, null, null, 'dddddd6', null, '26', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45909', '测试7', null, null, null, 'dddddd7', null, '27', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45912', '测试8', null, null, null, 'dddddd8', null, '28', 'A', '2014-12-08 15:47:53', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('45937', '用户们么么么么', null, null, null, 'dddddd', null, '20', 'A', '2014-12-08 15:47:54', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('80042', 'lyhTest', null, null, null, null, null, null, 'A', '2014-12-09 10:42:55', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('80043', '1', '2', null, '2', '2@2.xx', null, '2', 'A', '2014-12-09 10:48:45', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('80159', 'sdfsfsfsfd', 'sfsfds', '', '', '', null, null, '', '2014-12-11 19:04:21', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('80163', 'aa', '', 'aaa', '2222', '', null, null, 'X', '2015-07-21 19:35:51', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('80164', '用户名称', '啊啊啊', 'aaaa', '1', '', null, null, 'A', '2015-07-21 20:09:52', null, null, null, null, null, null);
INSERT INTO `am_user` VALUES ('80166', '1', '1', '1', '1', '1', null, '1', 'X', '2015-07-30 14:28:40', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `am_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `am_user_role`;
CREATE TABLE `am_user_role` (
  `USER_ROLE_ID` int(11) NOT NULL COMMENT '主键',
  `ROLE_ID` int(11) DEFAULT NULL COMMENT '角色标识',
  `USER_ID` int(11) DEFAULT NULL COMMENT '用户标识',
  `CREATED_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_USER_ROLE_REF_USER` (`USER_ID`),
  KEY `FK_USER_ROLE_REF_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_USER_ROLE_REF_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `am_role` (`ROLE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USER_ROLE_REF_USER` FOREIGN KEY (`USER_ID`) REFERENCES `am_user` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of am_user_role
-- ----------------------------
INSERT INTO `am_user_role` VALUES ('1', '1', '1', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('2', '1', '1', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('3', '1', '3', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('4', '1', '4', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('5', '1', '5', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('6', '1', '6', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('7', '1', '7', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('8', '1', '8', '2014-11-12 17:27:44');
INSERT INTO `am_user_role` VALUES ('9', '1', '9', '2014-11-12 17:27:44');

-- ----------------------------
-- Table structure for `wf_file_manager`
-- ----------------------------
DROP TABLE IF EXISTS `wf_file_manager`;
CREATE TABLE `wf_file_manager` (
  `file_id` int(11) DEFAULT NULL COMMENT '附件主键',
  `file_name` varchar(64) DEFAULT NULL COMMENT '附件名称',
  `file_size` int(11) DEFAULT NULL COMMENT '文件大小',
  `file_type` varchar(30) DEFAULT NULL COMMENT '附件类型',
  `physics_path` varchar(100) DEFAULT NULL COMMENT '物理路径',
  `virtual_path` varchar(100) DEFAULT NULL COMMENT '逻辑路径',
  `is_preview` varchar(3) DEFAULT NULL COMMENT '是否预览',
  `is_convert` varchar(3) DEFAULT NULL COMMENT '是否转换',
  `status` varchar(3) DEFAULT NULL COMMENT '状态',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_user` varchar(32) DEFAULT NULL COMMENT '创建者'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件管理';

-- ----------------------------
-- Records of wf_file_manager
-- ----------------------------

-- ----------------------------
-- Table structure for `wf_init_id`
-- ----------------------------
DROP TABLE IF EXISTS `wf_init_id`;
CREATE TABLE `wf_init_id` (
  `TABLE_NAME` varchar(64) NOT NULL COMMENT '表名',
  `COLUMN_NAME` varchar(64) NOT NULL COMMENT '列名',
  `SCHEMA_NAME` varchar(64) NOT NULL DEFAULT 'DEF' COMMENT '数据库实例',
  `DATA_TYPE` char(1) DEFAULT NULL COMMENT '数据类型',
  `ID_LENGTH` int(3) DEFAULT NULL COMMENT 'ID的位长',
  `REF_CODE` int(8) DEFAULT NULL COMMENT '引用编码',
  `REF_TYPE` char(1) DEFAULT NULL COMMENT '引用类型',
  `CURRENT_VALUE` bigint(20) DEFAULT NULL COMMENT '当前最大标识值',
  `ID_STEP` int(9) DEFAULT NULL COMMENT '每次增加的步长',
  PRIMARY KEY (`TABLE_NAME`,`COLUMN_NAME`,`SCHEMA_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wf_init_id
-- ----------------------------
INSERT INTO `wf_init_id` VALUES ('AM_USER', 'USER_ID', 'DEF', '1', '1', null, '1', '80166', '1');
INSERT INTO `wf_init_id` VALUES ('AM_USER_TMP', 'USER_ID', 'DEF', '1', '1', null, null, '117', '1');
INSERT INTO `wf_init_id` VALUES ('EDU_STUDENT', 'STU_ID', 'DEF', '1', '5', null, null, '17', '1');
INSERT INTO `wf_init_id` VALUES ('EHCACHE', 'EMP_ID', 'DEF', '1', null, null, null, '128', '1');
INSERT INTO `wf_init_id` VALUES ('SYS_PARAM', 'PARAM_ID', 'DEF', '1', '1', null, null, '71', '1');
INSERT INTO `wf_init_id` VALUES ('TEST', 'TEST_ID', 'DEF', '1', '1', '1', '1', '12', '1');
INSERT INTO `wf_init_id` VALUES ('TEST_PROC', 'PROC_ID', 'DEF', '1', '11', null, null, '123656789', '1');
INSERT INTO `wf_init_id` VALUES ('USER', 'USER_ID', 'DEF', '1', '1', '1', '1', '22103', '2');

-- ----------------------------
-- Procedure structure for `SequenceProc`
-- ----------------------------
DROP PROCEDURE IF EXISTS `SequenceProc`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `SequenceProc`(IN `tableName` varchar(250),IN `columnName` varchar(250),IN `schemaName` varchar(250),IN `count` int,OUT `resultStr` varchar(60000))
BEGIN
	DECLARE	result_str VARCHAR (60000);
  DECLARE currentId INT DEFAULT -1;
  DECLARE idStep INT DEFAULT -1;
  DECLARE i INT DEFAULT 0;
	DECLARE lock_result INT;
  IF get_lock('sp_critical_section_lock',60) THEN
		SET autocommit = 0;
		SELECT
			t.CURRENT_VALUE,
			t.ID_STEP
		INTO
			currentId,
			idStep
		FROM
			wf_init_id t
		WHERE
			t.TABLE_NAME = tableName
		AND t.SCHEMA_NAME = schemaName
		AND t.COLUMN_NAME = columnName;
		#返回结果集处理
		IF
			currentId = -1
		THEN
		#如果没有查询到相应的记录，返回空值给客户端 
			SET  result_str = '';
		ELSE   
			SET  result_str = '';
			while i<count do
			begin
				SET currentId:=currentId+idStep;
				#当第一次添加的时候，不用加','
				IF i = 0
				THEN
					SET result_str := currentId;
				ELSE
					SET result_str := CONCAT(result_str,',',currentId);
				END IF;
				SET i:=i+1;			
			end;
			end while;
		#修改ID表的信息
			UPDATE wf_init_id t 
			SET t.CURRENT_VALUE=currentId 
			WHERE 
			t.TABLE_NAME = tableName
			AND t.SCHEMA_NAME = schemaName
			AND t.COLUMN_NAME = columnName;
			COMMIT;
			SET resultStr:=result_str;
		END IF;
		SET lock_result=release_lock('sp_critical_section_lock');
	END IF;
END
;;
DELIMITER ;
