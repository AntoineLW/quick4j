package com.eliteams.quick4j.core.util;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class LocationUtils {

    static Logger logger  =  Logger.getLogger(LocationUtils.class);

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s*1000;
        return s;
    }

    public static double getLongitude(String locationJson) {
        return getLocation(locationJson, "longitude");
    }

    public static double getLatitude(String locationJson) {
        return getLocation(locationJson, "latitude");
    }

    private static double getLocation(String loationJson, String field) {

        logger.info("getLocation with loationJson: " + loationJson + ", field: " + field);

        try {
            JSONObject jsonObject = JSONObject.fromObject(loationJson);
            if (jsonObject.containsKey(field))
                return jsonObject.getDouble(field);
            return 0;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(getLatitude("{\"longitude\":113.886316,\"latitude\":27.634686}"));
    }
}