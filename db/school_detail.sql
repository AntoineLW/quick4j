use school;
-- ----------------------------
-- 创建新表, 学校表SCHOOL_DETAIL表
-- ----------------------------
DROP TABLE IF EXISTS school_detail;
CREATE TABLE school_detail(
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  school_id varchar(80) NOT NULL DEFAULT '' COMMENT '学校的唯一id',
  school_name varchar(200) NOT NULL DEFAULT '' COMMENT '学校名称',
  school_abbreviate varchar(100) NOT NULL DEFAULT '' COMMENT '学校缩写',
  school_address text COMMENT '学校地址',
  school_coordinate varchar(100) NOT NULL DEFAULT '' COMMENT '学校坐标',
  province_code int NOT NULL DEFAULT 0 COMMENT '省份编码',
  province_name varchar(20) NOT NULL DEFAULT '' COMMENT '省份名称',
  city_code int NOT NULL DEFAULT 0 COMMENT '城市编码',
  city_name varchar(60) NOT NULL DEFAULT '' COMMENT '城市名称',
  district_code int NOT NULL DEFAULT 0 COMMENT '区编码',
  district_name varchar(60) NOT NULL DEFAULT '' COMMENT '区名称',
  canteen_list varchar(100) NOT NULL DEFAULT '' COMMENT '食堂列表',
  seller_list varchar(100) NOT NULL DEFAULT '' COMMENT '商家列表',
  status varchar(60) NOT NULL DEFAULT '' COMMENT '状态 initial, online, offline, invalid',
  school_photo_jsons text COMMENT '学校照片json',
  contract_photo_jsons text COMMENT '合同照片json',
  extra_data1 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息1',
  extra_data2 varchar(255) NOT NULL DEFAULT '' COMMENT '额外信息2',
  create_time bigint(20) unsigned NOT NULL default 0 COMMENT '创建时间，毫秒',
  update_time bigint(20) unsigned NOT NULL default 0 COMMENT '更新时间，毫秒',
  online_time bigint(20) unsigned NOT NULL default 0 COMMENT '上线时间，毫秒',
  offline_time bigint(20) unsigned NOT NULL default 0 COMMENT '下线时间，毫秒',
  UNIQUE KEY uk_school_id(school_id),
  KEY idx_status(status)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校表';