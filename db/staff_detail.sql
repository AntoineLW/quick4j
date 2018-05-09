-- ----------------------------
-- 创建新表, 用户表STAFF_DETAIL表
-- ----------------------------
DROP TABLE IF EXISTS staff_detail;
CREATE TABLE staff_detail(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  staff_id varchar(80) NOT NULL DEFAULT '' COMMENT '工作人员的唯一id',
  login_type varchar(80) NOT NULL DEFAULT '' COMMENT '登录方式',
  login_id varchar(80) NOT NULL DEFAULT '' COMMENT '登录ID',
  login_pass_encrypt varchar(200) NOT NULL DEFAULT '' COMMENT '登录密码',
  phone_number varchar(20) NOT NULL DEFAULT '' COMMENT '电话号码',
  staff_type varchar(20) NOT NULL DEFAULT '' COMMENT '工作人员类型',
  status varchar(60) NOT NULL DEFAULT '' COMMENT '状态 initial, buying, sending, finish, rest',
  cert_status varchar(60) NOT NULL DEFAULT '' COMMENT '审核状态 initial, failed, success',
  avg_score float NOT NULL DEFAULT 0 COMMENT '平均评分',
  tag text COMMENT '评价',
  finish_order_count bigint(20) unsigned NOT NULL default 0 COMMENT '完成订单数量',
  assign_order_count bigint(20) unsigned NOT NULL default 0 COMMENT '分配订单数量',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  register_time bigint(20) unsigned NOT NULL default 0 COMMENT '注册时间，毫秒',
  last_reception_time bigint(20) unsigned NOT NULL default 0 COMMENT '上次接单时间，毫秒',
  UNIQUE KEY uk_staff_id(staff_id),
  INDEX idx_phone_number(phone_number)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作人员表';