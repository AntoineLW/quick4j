-- ----------------------------
-- 创建新表, 代跑腿订单表ACTION_ORDER表
-- ----------------------------
DROP TABLE IF EXISTS action_order;
CREATE TABLE action_order(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  order_id varchar(80) NOT NULL DEFAULT '' COMMENT '订单的唯一id',
  status varchar(60) NOT NULL DEFAULT '' COMMENT '状态 initial, not_pay, paied, finished, canceled, invalid',
  action_desc text COMMENT '订单描述',
  action_type varchar(255) NOT NULL DEFAULT '' COMMENT 'inner, outer 校内，校外',
  total_price bigint(20) unsigned NOT NULL default 0 COMMENT '总价格，分',
  distribution_price bigint(20) unsigned NOT NULL default 0 COMMENT '配送价格，分',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  paid_time bigint(20) unsigned NOT NULL default 0 COMMENT '支付时间，毫秒',
  cancel_time bigint(20) unsigned NOT NULL default 0 COMMENT '取消时间，毫秒',
  finish_time bigint(20) unsigned NOT NULL default 0 COMMENT '结束时间，毫秒',
  UNIQUE KEY uk_order_id(order_id),
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代跑腿订单表';