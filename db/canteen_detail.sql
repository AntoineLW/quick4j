use school;
-- ----------------------------
-- 创建新表, 食堂表CANTEEN_DETAIL表
-- ----------------------------
DROP TABLE IF EXISTS canteen_detail;
CREATE TABLE canteen_detail(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  canteen_id varchar(80) NOT NULL DEFAULT '' COMMENT '商家的唯一id',
  canteen_name varchar(200) NOT NULL DEFAULT '' COMMENT '商家名称',
  canteen_address text COMMENT '商家地址',
  canteen_coordinate varchar(100) NOT NULL DEFAULT '' COMMENT '食堂坐标',
  canteen_desc text COMMENT '食堂描述',
  canteen_info text COMMENT '食堂信息',
  province_code int NOT NULL DEFAULT 0 COMMENT '省份编码',
  province_name varchar(20) NOT NULL DEFAULT '' COMMENT '省份名称',
  city_code int NOT NULL DEFAULT 0 COMMENT '城市编码',
  city_name varchar(60) NOT NULL DEFAULT '' COMMENT '城市名称',
  district_code int NOT NULL DEFAULT 0 COMMENT '区编码',
  district_name varchar(60) NOT NULL DEFAULT '' COMMENT '区名称',
  status varchar(60) NOT NULL DEFAULT '' COMMENT '状态 initial, online, offline, invalid',
  canteen_photo_jsons text COMMENT '食堂照片json',
  contract_photo_jsons text COMMENT '合同照片json',
  belong_school varchar(80) NOT NULL DEFAULT '' COMMENT '隶属的学校id',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  online_time bigint(20) unsigned NOT NULL default 0 COMMENT '上线时间，毫秒',
  offline_time bigint(20) unsigned NOT NULL default 0 COMMENT '下线时间，毫秒',
  UNIQUE KEY uk_canteen_id(canteen_id),
  KEY idx_status(status)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='食堂表';