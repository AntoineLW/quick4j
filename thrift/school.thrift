namespace java com.eliteams.quick4j.web.model.school

struct SchoolDetail {
    1: i64 id;
    2: string schoolId;
    3: string schoolName;
    4: string schoolAbbreviate;
    5: string schoolAddress;
    6: string schoolCoordinate;
    7: i32 provinceCode;
    8: string provinceName;
    9: i32 cityCode;
    10: string cityName;
    11: i32 districtCode;
    12: string districtName;
    13: string canteenList;
    14: string sellerList;
    15: string status;
    16: string schoolPhotoJsons;
    17: string contractPhotoJsons;
    18: string extraData1;
    19: string extraData2;
    20: i64 createTime;
    21: i64 updateTime;
    22: i64 onlineTime;
    23: i64 offlineTime;
}

struct CanteenDetail {
    1: i64 id;
    2: string canteenId;
    3: string canteenName;
    4: string canteenAddress;
    5: string canteenCoordinate;
    6: string canteenDesc;
    7: string canteenInfo;
    8: i32 provinceCode;
    9: string provinceName;
    10: i32 cityCode;
    11: string cityName;
    12: i32 districtCode;
    13: string districtName;
    14: string status;
    15: string canteenPhotoJsons;
    16: string contractPhotoJsons;
    17: string belongSchool;
    18: string extraData1;
    19: string extraData2;
    20: i64 createTime;
    21: i64 updateTime;
    22: i64 onlineTime;
    23: i64 offlineTime;
}

struct SellerDetail {
    1: i32 id;
    2: string sellerId;
    3: string sellerName;
    4: string sellerAddress;
    5: string sellerCoordinate;
    6: string sellerDesc;
    7: string sellerInfo;
    8: i32 provinceCode;
    9: string provinceName;
    10: i32 cityCode;
    11: string cityName;
    12: i32 districtCode;
    13: string districtName;
    14: string status;
    15: string sellerPhotoJsons;
    16: string contractPhotoJsons;
    17: string belongSchool;
    18: string extraData1;
    19: string extraData2;
    20: i64 createTime;
    21: i64 updateTime;
    22: i64 onlineTime;
    23: i64 offlineTime;
}

struct MenuDetail {
    1: i64 id;
    2: string menuId;
    3: string menuName;
    4: string classification;
    5: string description;
    6: i64 actualPrice;
    7: i64 originPrice;
    8: string discountType;
    9: string belongCanteen;
    10: string belongSeller;
    11: string menuPhotoJsons;
    12: string status;
    13: string extraData1;
    14: string extraData2;
    15: i64 createTime;
    16: i64 updateTime;
    17: i64 onSaleTime;
    18: i64 offSaleTime;
}

struct BuyOrder {
    1: i64 id;
    2: string orderId;
    3: string status;
    4: string belongCanteen;
    5: string belongSeller;
    6: i64 totalPrice;
    7: i64 distributionPrice;
    8: string menuList;
    9: string userId;
    10: string distributorId;
    11: string extraData1;
    12: string extraData2;
    13: i64 createTime;
    14: i64 updateTime;
    15: i64 paidTime;
    16: i64 cancelTime;
    17: i64 finishTime;
}

struct ActionOrder {
    1: i64 id;
    2: string orderId;
    3: string status;
    4: string actionDesc;
    5: string actionType;
    6: i64 totalPrice;
    7: i64 distributionPrice;
    8: string userId;
    9: string distributorId;
    10: string extraData1;
    11: string extraData2;
    12: i64 createTime;
    13: i64 updateTime;
    14: i64 paidTime;
    15: i64 cancelTime;
    16: i64 finishTime;
}

struct UserDetail {
    1: i64 id;
    2: string userId;
    3: string loginType;
    4: string loginId;
    5: string loginPass;
    6: string loginPassEncrypt;
    7: string phoneNumber;
    8: string status;
    9: string addressList;
    10: string addressListEncrypt;
    11: string primaryAddress;
    12: string primaryAddressEncrypt;
    13: string shoppingCart;
    14: string shoppingCartEncrypt;
    15: string extraData1;
    16: string extraData2;
    17: i64 createTime;
    18: i64 updateTime;
    19: i64 registerTime;
    20: i64 lastLoginTime;
    21: i64 lastBuyTime;
}

struct StaffDetail {
    1: i64 id;
    2: string staffId;
    3: string loginType;
    4: string loginId;
    5: string loginPass;
    6: string loginPassEncrypt;
    7: string phoneNumber;
    8: string staffType;
    9: string status;
    11: string certStatus;
    12: double avgScore;
    13: string tag;
    14: i32 finishOrderCount;
    15: i32 assignOrderCount;
    16: string extraData1;
    17: string extraData2;
    18: i64 createTime;
    19: i64 updateTime;
    20: i64 registerTime;
    21: i64 lastReceptionTime;
}