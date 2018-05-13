package com.eliteams.quick4j.core.util;

import com.eliteams.quick4j.web.model.school.CanteenDetail;
import com.eliteams.quick4j.web.model.school.SellerDetail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class JsonResponseUtils {

    public static String partnerResponseJson(List<CanteenDetail> canteenDetails, List<SellerDetail> sellerDetails,
                                             double longitude, double latitude) {

        JSONObject resultJson = new JSONObject();

        JSONArray colArray = new JSONArray();
        colArray.add("partner_id"); //商户ID
        colArray.add("pic_url"); //照片路径
        colArray.add("name"); //商户名称
        colArray.add("month_sale"); //月销量
        colArray.add("distance"); //距离
        colArray.add("price"); //价格(分)
        colArray.add("promotion"); //优惠信息
        colArray.add("longitude"); //经度
        colArray.add("latitude"); //纬度
        colArray.add("partner_type"); //商户类型(1食堂,2商户)
        colArray.add("begin_delivery_fee"); //起送价格(分)
        colArray.add("delivery_fee"); //配送价格(分)
        colArray.add("notice"); //通知
        resultJson.put("cols", colArray);

        int number = 0;
        if (canteenDetails != null)
            number += canteenDetails.size();
        if (sellerDetails != null)
            number += sellerDetails.size();
        resultJson.put("number", number);

        JSONArray dataArray = new JSONArray();
        if (canteenDetails != null) {
            for (CanteenDetail canteenDetail : canteenDetails) {
                double partnerLongitude = LocationUtils.getLongitude(canteenDetail.canteenCoordinate);
                double partnerLatitude = LocationUtils.getLatitude(canteenDetail.canteenCoordinate);
                double distance = LocationUtils.getDistance(latitude, longitude, partnerLatitude, partnerLongitude);

                JSONArray partnerArray = new JSONArray();
                partnerArray.add(canteenDetail.canteenId); //食堂ID
                partnerArray.add(""); //照片路径
                partnerArray.add(canteenDetail.canteenName); //商户名称
                partnerArray.add(0); //月销量
                partnerArray.add(distance); //距离
                partnerArray.add(0); //价格(分)
                partnerArray.add(""); //优惠信息
                partnerArray.add(partnerLongitude); //经度
                partnerArray.add(partnerLatitude); //纬度
                partnerArray.add(1); //商户类型(1食堂,2商户)
                partnerArray.add(0); //起送价格(分)
                partnerArray.add(0); //配送价格(分)
                partnerArray.add(""); //通知

                dataArray.add(partnerArray);
            }
        }
        if (sellerDetails != null) {
            for (SellerDetail sellerDetail : sellerDetails) {
                double partnerLongitude = LocationUtils.getLongitude(sellerDetail.sellerCoordinate);
                double partnerLatitude = LocationUtils.getLatitude(sellerDetail.sellerCoordinate);
                double distance = LocationUtils.getDistance(latitude, longitude, partnerLatitude, partnerLongitude);

                JSONArray partnerArray = new JSONArray();
                partnerArray.add(sellerDetail.sellerId); //食堂ID
                partnerArray.add(""); //照片路径
                partnerArray.add(sellerDetail.sellerName); //商户名称
                partnerArray.add(0); //月销量
                partnerArray.add(distance); //距离
                partnerArray.add(0); //价格(分)
                partnerArray.add(""); //优惠信息
                partnerArray.add(partnerLongitude); //经度
                partnerArray.add(partnerLatitude); //纬度
                partnerArray.add(1); //商户类型(1食堂,2商户)
                partnerArray.add(0); //起送价格(分)
                partnerArray.add(0); //配送价格(分)
                partnerArray.add(""); //通知

                dataArray.add(partnerArray);
            }
        }

        resultJson.put("partners", dataArray);
        return resultJson.toString();
    }

    public static void main(String[] args) {
        System.out.println(partnerResponseJson(null, null, 1,1));
    }
}
