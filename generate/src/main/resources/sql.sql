CREATE TABLE `u_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `consignee` varchar (32) NOT NULL COMMENT '收件人',
  `consignee_mobile` varchar (12) NOT NULL COMMENT '收件人手机号',
  `address` varchar (128) NOT NULL COMMENT '详细地址',
  `plot_id` bigint(20) NOT NULL COMMENT '小区id',
  `plot_name` varchar (32) NOT NULL COMMENT '小区名称',
  `collect_point_id` bigint(20) NOT NULL COMMENT '代收点id',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收货地址';

CREATE TABLE `sys_plot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar (32) NOT NULL COMMENT '名称',
  `county_id` bigint(20) NOT NULL COMMENT '区县id',
  `street_id` bigint(20) DEFAULT '0' COMMENT '街道id',
  `merchant_id` bigint(20) NOT NULL COMMENT '商家id',
  `collect_point_id` bigint(20) NOT NULL COMMENT '代收点id',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='小区';

CREATE TABLE `sys_collect_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `county_id` bigint(20) NOT NULL COMMENT '区县id',
  `merchant_id` bigint(20) NOT NULL COMMENT '商家id',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代收点';

CREATE TABLE `sys_merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar (64) NOT NULL COMMENT '姓名',
  `mobile` varchar (12) NOT NULL COMMENT '手机号',
  `id_card` varchar(18) NOT NULL COMMENT '身份证号',
  `county_id` bigint(20) NOT NULL COMMENT '区县id',
  `address` varchar (64) NOT NULL COMMENT '详细地址',
  `business_license` varchar (128) NOT NULL COMMENT '营业执照',
  `orientation` varchar (20) NOT NULL COMMENT '价格模板方位：EAST-东，WEST-西，SOUTH-南，NORTH-北',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(11) DEFAULT 0 COMMENT '状态：0-正常，1-审核中，2-冻结',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商家';

CREATE TABLE `t_banner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar (128) NOT NULL COMMENT '图片路径',
  `link` varchar (128) NOT NULL COMMENT '跳转',
  `type` int (11) NOT NULL COMMENT '类型：1-商品，2-活动，3-H5',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='banner';

CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_id` bigint(20) NOT NULL COMMENT '分类id',
  `base_class_id` bigint(20) NOT NULL COMMENT '一级分类id',
  `name` varchar (32) NOT NULL COMMENT '商品名称',
  `describe` varchar (128) NOT NULL COMMENT '描述',
  `spec` varchar (32) NOT NULL COMMENT '规格',
  `east` decimal(10,2) DEFAULT '0.00' COMMENT '东',
  `west` decimal(10,2) DEFAULT '0.00' COMMENT '西',
  `south` decimal(10,2) DEFAULT '0.00' COMMENT '南',
  `north` decimal(10,2) DEFAULT '0.00' COMMENT '北',
  `type` int (11) DEFAULT '0' COMMENT '类型：0-普通商品，1-折扣商品',
  `discount_price` decimal(10,2) DEFAULT '0.00' COMMENT '折扣价格',
  `discount_desc` varchar (32) DEFAULT '' COMMENT '折扣描述',
  `discount_end_time` varchar (32) DEFAULT '' COMMENT '折扣结束时间',
  `is_pre` tinyint(1) DEFAULT '0' COMMENT '是否预售（此预售为手动设置预售）',
  `is_hot` tinyint(1) DEFAULT '0' COMMENT '是否热门',
  `is_up` tinyint(1) DEFAULT '0' COMMENT '是否上架',
  `details` text COMMENT '详情',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品';

CREATE TABLE `g_price_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar (32) NOT NULL COMMENT '模板名',
  `describe` varchar (128) NOT NULL COMMENT '描述',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品价格模板';

CREATE TABLE `g_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint (20) NOT NULL COMMENT '商品id',
  `template_id` bigint(20) NOT NULL COMMENT '模板id',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品价格';


CREATE TABLE `t_group_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar (32) NOT NULL COMMENT '商品名称',
  `describe` varchar (128) NOT NULL COMMENT '描述',
  `spec` varchar (32) NOT NULL COMMENT '规格',
  `end_time` timestamp DEFAULT '' COMMENT '折扣结束时间',
  `details` text COMMENT '详情',
  `is_invalid` tinyint(1) DEFAULT '0' COMMENT '是否失效',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='团购商品';

CREATE TABLE `t_group_goods_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL COMMENT '团购商品id',
  `satisfy_num` int(11) NOT NULL COMMENT '满足人数',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY  `goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='团购商品阶梯价格';

CREATE TABLE `t_seckill_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar (32) NOT NULL COMMENT '商品名称',
  `describe` varchar (128) NOT NULL COMMENT '描述',
  `spec` varchar (32) NOT NULL COMMENT '规格',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价格',
  `old_price` decimal(10,2) DEFAULT '0.00' COMMENT '原价',
  `start_time` timestamp DEFAULT '' COMMENT '开始时间',
  `end_time` timestamp DEFAULT '' COMMENT '结束时间',
  `details` text COMMENT '详情',
  `is_invalid` tinyint(1) DEFAULT '0' COMMENT '是否失效',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='秒杀商品';


CREATE TABLE `t_merchant_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` bigint(20) NOT NULL COMMENT '商家id',
  `merchant_name` varchar (32) NOT NULL COMMENT '商家名称',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_name` varchar (32) NOT NULL COMMENT '商品名称',
  `goods_type` int(11) DEFAULT 0 COMMENT '商品类型：0-普通商品，1-折扣商品，2-团购商品，3-秒杀商品',
  `stock` int(11) DEFAULT 0 COMMENT '库存',
  `is_up` tinyint(1) DEFAULT 1 COMMENT '是否上架',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商家商品';

CREATE TABLE `g_images` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20)  NOT NULL COMMENT '商品id',
  `is_cover` tinyint(1) DEFAULT '0' COMMENT '是否是封面',
  `rank` int(11) DEFAULT '0' COMMENT '排序',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品图片';

CREATE TABLE `g_classify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar (16) NOT NULL COMMENT '名称',
  `img_path` varchar (128) DEFAULT '' COMMENT '图片路径',
  `parent` bigint(20) DEFAULT '0' COMMENT '上级',
  `rank` int(11) DEFAULT '0' COMMENT '排序',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `parent` (`parent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品分类';

CREATE TABLE `g_car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20)  NOT NULL COMMENT '商品id',
  `num` int(11) NOT NULL COMMENT '数量',
  `activity_type` int(11) DEFAULT '0' COMMENT '活动类型：0-普通商品，1-折扣商品',
  `add_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车';


