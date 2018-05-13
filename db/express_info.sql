-- ----------------------------
-- 创建新表, 物流信息EXPRESS_INFO表
-- ----------------------------
DROP TABLE IF EXISTS buy_order;
CREATE TABLE buy_order(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id bigint(20) unsigned NOT NULL COMMENT '用户id',
  address varchar(80) NOT NULL DEFAULT '' COMMENT '物流地址',
  receptor_name varchar(80) NOT NULL DEFAULT '' COMMENT '接收人姓名',
  receptor_phonenumber varchar(80) NOT NULL DEFAULT '' COMMENT '接收人电话',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流信息表';

