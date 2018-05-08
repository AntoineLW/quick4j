-- ----------------------------
-- 创建新表, 商品表MENU_DETAIL表
-- ----------------------------
DROP TABLE IF EXISTS menu_detail;
CREATE TABLE menu_detail(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  menu_id varchar(80) NOT NULL DEFAULT '' COMMENT '商品的唯一id',
  menu_name varchar(200) NOT NULL DEFAULT '' COMMENT '商品名称',
  classification varchar(40) NOT NULL DEFAULT '' COMMENT '商品分类',
  descrption text COMMENT '描述',
  actual_price bigint(20) unsigned NOT NULL default 0 COMMENT '实际售卖价格，分',
  origin_price bigint(20) unsigned NOT NULL default 0 COMMENT '原始价格，分',
  discount_type varchar(60) NOT NULL DEFAULT '' COMMENT '打折形式',
  belong_canteen varchar(80) NOT NULL DEFAULT '' COMMENT '隶属的食堂ID',
  belong_seller varchar(80) NOT NULL DEFAULT '' COMMENT '隶属的商家ID',
  menu_photo_jsons text COMMENT '商品照片json',
  status varchar(60) NOT NULL DEFAULT '' COMMENT '状态 initial, onSale, offSale, invalid',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  on_sale_time bigint(20) unsigned NOT NULL default 0 COMMENT '上线时间，毫秒',
  off_sale_time bigint(20) unsigned NOT NULL default 0 COMMENT '下线时间，毫秒',
  UNIQUE KEY uk_menu_detail(menu_detail),
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';