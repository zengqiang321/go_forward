package com.jack.other;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2019/6/21.
 */
public class T1 {

    public static void main(String[] args) {
        String sql="UPDATE $readme SET local_goods_number=0,other_goods_number=0;";
        char[] chara="0123456789abcdef".toCharArray();
        char[] charb="0123456789abcdef".toCharArray();
        List<String> tables = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<chara.length;i++){
            for (int j=0;j<charb.length;j++) {
                String newtable = "who_cart_cookieid_"+chara[i]+""+charb[j];
                String s = sql.replace("$readme",newtable);
                tables.add(s);
                System.out.println(s);
            }
        }

        chara="0123456789".toCharArray();
        for (int i=0;i<chara.length;i++){
            for (int j=0;j<chara.length;j++) {
                String newtable = "who_cart_userid_"+Integer.parseInt(chara[i]+""+chara[j]);
                String s = sql.replace("$readme",newtable);
                tables.add(s);
                System.out.println(s);
            }
        }
//
//        try {
//            FileUtils.writeLines(new java.io.File("/Users/jack/Desktop/splitTable_bindCartId.sql"),"utf-8",tables);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    public static void main1(String[] args) {
        String table="CREATE TABLE `who_cart_cookieid_` (\n" +
                "  `rec_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键,唯一索引',\n" +
                "  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',\n" +
                "  `cookie_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'Cookie内的$_COOKIE [wholesale]',\n" +
                "  `goods_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '商品id',\n" +
                "  `cat_id` smallint(5) DEFAULT '0' comment '分类ID',\n" +
                "  `activity_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '活动价格',\n" +
                "  `activity_price_currency` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '活动价格(本地货币)',\n" +
                "  `currency` varchar(20) NOT NULL DEFAULT '' COMMENT '加购时对应的货币',\n" +
                "  `goods_thumb` varchar(255) NOT NULL DEFAULT '' COMMENT '商品的缩略图片',\n" +
                "  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '购买的数量',\n" +
                "  `sku_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户所选择的商品属性id,同who_sku_relation的rec_id',\n" +
                "  `app_version` varchar(20) NOT NULL DEFAULT '' COMMENT '加购 App 版本号',\n" +
                "  `site_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '站点 ID,0:jollychic,readme:Nimini,2:MarkaVIP',\n" +
                "  `source_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '加购来源类型，(来源:0:PC,3:安卓,4:iphone,5:ipad,6:wap)',\n" +
                "  `add_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',\n" +
                "  `lost_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '失效时间',\n" +
                "  `is_gift` tinyint(2) NOT NULL DEFAULT '0' COMMENT '礼品标记 0:普通商品，readme：购物车活动礼品, 5:闪购, 11：普通礼品，13 ：绑定赠品，14：点蜡烛活动加购，15 预售(预留)，28 购物车换购',\n" +
                "  `event_id` int(10) DEFAULT '0' comment '事件活动ID',\n" +
                "  `promote_sn` varchar(16) NOT NULL DEFAULT '' COMMENT '购物车优惠编号',\n" +
                "  `goods_other_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '商品定制 SKU 信息',\n" +
                "  `bind_cart_id` bigint(20) DEFAULT '0' COMMENT '单品捆绑赠的主商品id  0 表示非单品捆绑赠 赠品；非0 表示捆绑赠赠品',\n" +
                "  `depot_id` int(11) NOT NULL DEFAULT 'readme' COMMENT '仓库id',\n" +
                "  `size_type` varchar(10) DEFAULT '' COMMENT '对应的尺码类型名称,EU、UK、INT、US',\n" +
                "  `sku_country_value` varchar(256) DEFAULT '' COMMENT '对应国家对应的sku值',\n" +
                "  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一标志',\n" +
                "  `old_cart_id` bigint(20) unsigned NOT NULL default 0  COMMENT '对应who_cart.rec_id',\n" +
                "  PRIMARY KEY (`rec_id`),\n" +
                "  KEY `idx_old_cart_id` (`old_cart_id`),\n" +
                "  KEY `idx_cookie_id` (`cookie_id`),\n" +
                "  KEY `idx_goods_id` (`goods_id`),\n" +
                "  KEY `idx_sku_id` (`sku_id`),\n" +
                "  KEY `idx_cart_bind_cart_id` (`bind_cart_id`),\n" +
                "  KEY `idx_uuid` (`uuid`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=readme DEFAULT CHARSET=utf8 COMMENT='购物车表';\n\n";
        char[] chara="0123456789abcdef".toCharArray();
        char[] charb="0123456789abcdef".toCharArray();
        List<String> tables = new ArrayList<>();
        for (int i=0;i<chara.length;i++){
            for (int j=0;j<charb.length;j++) {
                String newtable = "who_cart_cookieid_"+chara[i]+""+charb[j];
                String s = table.replaceAll("who_cart_cookieid_",newtable);
                tables.add(s);

                System.out.println(chara[i]+""+charb[j]);
            }
        }

        table = "CREATE TABLE `who_cart_userid_` (\n" +
                "  `rec_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键,唯一索引',\n" +
                "  `user_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',\n" +
                "  `cookie_id` varchar(32) NOT NULL DEFAULT '' COMMENT 'Cookie内的$_COOKIE [wholesale]',\n" +
                "  `goods_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '商品id',\n" +
                "  `cat_id` smallint(5) DEFAULT '0' comment '分类ID',\n" +
                "  `activity_price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '活动价格',\n" +
                "  `activity_price_currency` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '活动价格(本地货币)',\n" +
                "  `currency` varchar(20) NOT NULL DEFAULT '' COMMENT '加购时对应的货币',\n" +
                "  `goods_thumb` varchar(255) NOT NULL DEFAULT '' COMMENT '商品的缩略图片',\n" +
                "  `goods_number` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '购买的数量',\n" +
                "  `sku_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '用户所选择的商品属性id,同who_sku_relation的rec_id',\n" +
                "  `app_version` varchar(20) NOT NULL DEFAULT '' COMMENT '加购 App 版本号',\n" +
                "  `site_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '站点 ID,0:jollychic,readme:Nimini,2:MarkaVIP',\n" +
                "  `source_type` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '加购来源类型，(来源:0:PC,3:安卓,4:iphone,5:ipad,6:wap)',\n" +
                "  `add_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '添加时间',\n" +
                "  `lost_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '失效时间',\n" +
                "  `is_gift` tinyint(2) NOT NULL DEFAULT '0' COMMENT '礼品标记 0:普通商品，readme：购物车活动礼品, 5:闪购, 11：普通礼品，13 ：绑定赠品，14：点蜡烛活动加购，15 预售(预留)，28 购物车换购',\n" +
                "  `event_id` int(10) DEFAULT '0' COMMENT '事件活动ID',\n" +
                "  `promote_sn` varchar(16) NOT NULL DEFAULT '' COMMENT '购物车优惠编号',\n" +
                "  `goods_other_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '商品定制 SKU 信息',\n" +
                "  `bind_cart_id` bigint(20) DEFAULT '0' COMMENT '单品捆绑赠的主商品id  0 表示非单品捆绑赠 赠品；非0 表示捆绑赠赠品',\n" +
                "  `depot_id` int(11) NOT NULL DEFAULT 'readme' COMMENT '仓库id',\n" +
                "  `size_type` varchar(10) DEFAULT '' COMMENT '对应的尺码类型名称,EU、UK、INT、US',\n" +
                "  `sku_country_value` varchar(256) DEFAULT '' COMMENT '对应国家对应的sku值',\n" +
                "  `uuid` varchar(32) NOT NULL DEFAULT '' COMMENT '唯一标志',\n" +
                "  `old_cart_id` bigint(20) unsigned NOT NULL default 0  COMMENT '对应who_cart.rec_id',\n" +
                "  PRIMARY KEY (`rec_id`),\n" +
                "  KEY `idx_user_id` (`user_id`),\n" +
                "  KEY `idx_old_cart_id` (`old_cart_id`),\n" +
                "  KEY `idx_goods_id` (`goods_id`),\n" +
                "  KEY `idx_sku_id` (`sku_id`),\n" +
                "  KEY `idx_user_id_sku_id` (`user_id`, `sku_id`),\n" +
                "  KEY `idx_cart_bind_cart_id` (`bind_cart_id`),\n" +
                "  KEY `idx_uuid` (`uuid`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=readme DEFAULT CHARSET=utf8 COMMENT='购物车表';\n\n";
        chara="0123456789".toCharArray();
        for (int i=0;i<chara.length;i++){
            for (int j=0;j<chara.length;j++) {
                String newtable = "who_cart_userid_"+Integer.parseInt(chara[i]+""+chara[j]);
                String s = table.replaceAll("who_cart_userid_",newtable);
                tables.add(s);
            }
        }

        try {
            FileUtils.writeLines(new java.io.File("/Users/jack/Desktop/splitTable.sql"),"utf-8",tables);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
