-- ----------------------------
-- 创建新表, 购买订单表BUY_ORDER表
-- ----------------------------
DROP TABLE IF EXISTS buy_order;
CREATE TABLE buy_order(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  order_id bigint(80) NOT NULL COMMENT '主订单id，如果订单是主订单，则和id相同',
  trace_id varchar(80) NOT NULL DEFAULT '' COMMENT 'traceid，自己生成的有意义的订单标识，主订单关注',
  status int(20) NOT NULL DEFAULT 0 COMMENT '状态 initial, paied, finished, canceled, invalid 主订单关注',
  express_id int(20) NOT NULL COMMENT '配送信息id',
  belong_canteen bigint(80) NOT NULL DEFAULT '' COMMENT '隶属的食堂ID 主订单关注',
  belong_seller bigint(80) NOT NULL DEFAULT '' COMMENT '隶属的商家ID 主订单关注',
  total_price bigint(20) unsigned NOT NULL default 0 COMMENT '总价格，分 订单总和，子订单同样有效',
  total_count bigint(20) unsigned NOT NULL default 0 COMMENT '总份数，个 订单总和，子订单同样有效',
  distribution_price bigint(20) unsigned NOT NULL default 0 COMMENT '配送价格，分，主订单关注',
  menu_id text COMMENT '餐品id,子订单关注',
  user_id bigint(80) NOT NULL DEFAULT '' COMMENT '用户id主订单关注',
  distributor_id bigint(80) NOT NULL DEFAULT '' COMMENT '配送员id主订单关注',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  paid_time bigint(20) unsigned NOT NULL default 0 COMMENT '支付时间，毫秒主订单关注',
  cancel_time bigint(20) unsigned NOT NULL default 0 COMMENT '取消时间，毫秒主订单关注',
  finish_time bigint(20) unsigned NOT NULL default 0 COMMENT '结束时间，毫秒主订单关注',
  send_time bigint(20) unsigned NOT NULL COMMENT '送达时间，毫秒主订单关注'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购买订单表';