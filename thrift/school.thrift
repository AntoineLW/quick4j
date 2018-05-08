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
