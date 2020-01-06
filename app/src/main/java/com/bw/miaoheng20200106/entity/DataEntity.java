package com.bw.miaoheng20200106.entity;

import java.util.List;

/**
 * 时间 :2020/1/6  9:23
 * 作者 :苗恒
 * 功能 :  展示右侧商品信息的实体类
 */
public class DataEntity {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * goods_id : 16966
         * goods_english_name : 德国OBB ROYAL BED
         * currency_price : ￥4708
         * rank_price : ￥0
         * goods_brokerage_per : 12.50
         * service_price :
         * shipping_price : ￥0
         * is_recommended : 1
         * is_on_sale : 1
         * goods_name : 90%鹅绒冬被Müritz米里茨系列 220*240cm（适用于1.8m的床）
         * goods_brief : 商品材质	德国白鹅羽绒；80支埃及长绒棉
         规格尺寸	220*240cm（适用于1.8m的床）
         商品重量	3300g
         包装方式	德国原装简约包装
         充绒量	1300g
         羽绒等级	DIN EN 12934 一级品
         蓬松度	754cuin
         含绒量	90%白鹅绒
         商品描述	1.采用德国高蓬松度白鹅绒，轻盈保暖0压感；2.100%埃及长绒棉，由60支升级为80支高密平纹面料，较升级前静音效果提升50%，欧标一等纺织品，婴儿可接触级别；3.欧洲防尘螨过敏技术认证，尘螨敏感者安享；4.德国箱式锁绒技术，轧光加密无涂层不跑绒；5.支持60℃机洗+烘干，洁净易打理。
         * weblink :
         * is_promote : 0
         * link_website :
         * goods_thumb : http://img.fulishe.com/images/201912/thumb_img/16966_thumb_G_1577166666809.jpeg
         * percentage : 0%
         * total_goods_brokerage : 588.5
         * is_favorited : 0
         * isNew : 0
         */

        private int goods_id;
        private String goods_english_name;
        private String currency_price;
        private String rank_price;
        private String goods_brokerage_per;
        private String service_price;
        private String shipping_price;
        private int is_recommended;
        private int is_on_sale;
        private String goods_name;
        private String goods_brief;
        private String weblink;
        private int is_promote;
        private String link_website;
        private String goods_thumb;
        private String percentage;
        private double total_goods_brokerage;
        private int is_favorited;
        private int isNew;

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_english_name() {
            return goods_english_name;
        }

        public void setGoods_english_name(String goods_english_name) {
            this.goods_english_name = goods_english_name;
        }

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }

        public String getRank_price() {
            return rank_price;
        }

        public void setRank_price(String rank_price) {
            this.rank_price = rank_price;
        }

        public String getGoods_brokerage_per() {
            return goods_brokerage_per;
        }

        public void setGoods_brokerage_per(String goods_brokerage_per) {
            this.goods_brokerage_per = goods_brokerage_per;
        }

        public String getService_price() {
            return service_price;
        }

        public void setService_price(String service_price) {
            this.service_price = service_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public int getIs_recommended() {
            return is_recommended;
        }

        public void setIs_recommended(int is_recommended) {
            this.is_recommended = is_recommended;
        }

        public int getIs_on_sale() {
            return is_on_sale;
        }

        public void setIs_on_sale(int is_on_sale) {
            this.is_on_sale = is_on_sale;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_brief() {
            return goods_brief;
        }

        public void setGoods_brief(String goods_brief) {
            this.goods_brief = goods_brief;
        }

        public String getWeblink() {
            return weblink;
        }

        public void setWeblink(String weblink) {
            this.weblink = weblink;
        }

        public int getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(int is_promote) {
            this.is_promote = is_promote;
        }

        public String getLink_website() {
            return link_website;
        }

        public void setLink_website(String link_website) {
            this.link_website = link_website;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public double getTotal_goods_brokerage() {
            return total_goods_brokerage;
        }

        public void setTotal_goods_brokerage(double total_goods_brokerage) {
            this.total_goods_brokerage = total_goods_brokerage;
        }

        public int getIs_favorited() {
            return is_favorited;
        }

        public void setIs_favorited(int is_favorited) {
            this.is_favorited = is_favorited;
        }

        public int getIsNew() {
            return isNew;
        }

        public void setIsNew(int isNew) {
            this.isNew = isNew;
        }
    }
}
