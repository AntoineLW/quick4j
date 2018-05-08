-- ----------------------------
-- 创建新表, 用户表USER_DETAIL表
-- ----------------------------
DROP TABLE IF EXISTS user_detail;
CREATE TABLE user_detail(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id varchar(80) NOT NULL DEFAULT '' COMMENT '用户的唯一id',
  login_type varchar(80) NOT NULL DEFAULT '' COMMENT '登录方式, phone_number, webchat, qq',
  login_id varchar(80) NOT NULL DEFAULT '' COMMENT '登录ID',
  login_pass_encrypt varchar(200) NOT NULL DEFAULT '' COMMENT '登录密码',
  phone_number varchar(20) NOT NULL DEFAULT '' COMMENT '电话号码',
  status varchar(60) NOT NULL DEFAULT '' COMMENT '状态 initial, online, offline, invalid',
  address_list_encrypt text COMMENT '地址列表',
  primary_address_encrypt text COMMENT '首选地址',
  shopping_cart_encrypt text COMMENT '购物车',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  register_time bigint(20) unsigned NOT NULL default 0 COMMENT '注册时间，毫秒',
  last_login_time bigint(20) unsigned NOT NULL default 0 COMMENT '上次登录时间，毫秒',
  last_buy_time bigint(20) unsigned NOT NULL default 0 COMMENT '上次购买时间，毫秒',
  UNIQUE KEY uk_user_id(user_id),
  INDEX idx_phone_number(phone_number),
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';