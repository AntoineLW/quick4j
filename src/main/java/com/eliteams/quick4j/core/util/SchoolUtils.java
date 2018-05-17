package com.eliteams.quick4j.core.util;

/**
 * Created by mi on 18-5-15.
 */
public class SchoolUtils {

    public enum SellerType {INVALID, CANTEEN, SELLER}

    private static String CANTEEN_PREFIX = "CAN_";
    private static String SELLER_PREFIX = "SEL_";

    public static SellerType getSellerType(String partnerId) {
        if (partnerId.contains(CANTEEN_PREFIX))
            return SellerType.CANTEEN;
        else if (partnerId.contains(SELLER_PREFIX))
            return SellerType.SELLER;
        else
            return SellerType.INVALID;
    }
}