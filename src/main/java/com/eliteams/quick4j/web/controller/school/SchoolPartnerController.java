package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.core.util.JsonResponseUtils;
import com.eliteams.quick4j.core.util.SchoolUtils;
import com.eliteams.quick4j.web.model.response.SchoolResponse;
import com.eliteams.quick4j.web.model.school.CanteenDetail;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import com.eliteams.quick4j.web.model.school.SellerDetail;
import com.eliteams.quick4j.web.service.CanteenService;
import com.eliteams.quick4j.web.service.SchoolService;
import com.eliteams.quick4j.web.service.SellerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping(value = "/school_partner")
public class SchoolPartnerController {

    Logger logger  =  Logger.getLogger(SchoolPartnerController.class);

    @Resource
    private CanteenService canteenService;

    @Resource
    private SellerService sellerService;

    @Resource
    private SchoolService schoolService;

    /**
     * 获取推荐商户信息
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    @RequestMapping(value = "get_recommand_partner_list", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse getRecommandPartnerList(@RequestParam(required=true,value="longitude") double longitude,
                                                  @RequestParam(required=true,value="latitude") double latitude) {
        logger.info("getRecommandPartnerList with longitude : " + longitude + ", latitude: " + latitude);

        //1、获取该地址对应的学校
        SchoolDetail schoolDetail = schoolService.getSchoolByLocation(longitude, latitude);
        if (schoolDetail == null)
            return new SchoolResponse(-1, "error", "不存在学校");

        //2、获取该学校推荐的食堂
        List<CanteenDetail> canteenDetails = canteenService.getRecommandCanteenList(schoolDetail, longitude, latitude);

        //3、获取该学校推荐的商家
        List<SellerDetail> sellerDetails = sellerService.getRecommandSellerList(schoolDetail, longitude, latitude);

        logger.info("getRecommandPartnerList with canteen size: " + canteenDetails.size() + ", seller size: " + sellerDetails.size());
        String result = JsonResponseUtils.partnerResponseJson(canteenDetails, sellerDetails, longitude, latitude);
        logger.info("getRecommandPartnerList with result: " + result);

        return new SchoolResponse(0, "ok", result);
    }


    /**
     * 获取所有商户信息
     * @param longitude 经度
     * @param latitude 纬度
     * @return
     */
    @RequestMapping(value = "get_all_partner_list", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse getAllPartnerList(@RequestParam(required=true,value="longitude") double longitude,
                                            @RequestParam(required=true,value="latitude") double latitude) {
        logger.info("getAllPartnerList with longitude : " + longitude + ", latitude: " + latitude);

        //1、获取该地址对应的学校
        SchoolDetail schoolDetail = schoolService.getSchoolByLocation(longitude, latitude);
        if (schoolDetail == null)
            return new SchoolResponse(-1, "error", "不存在学校");

        //2、获取该学校推荐的食堂
        List<CanteenDetail> canteenDetails = canteenService.getAllCanteenList(schoolDetail, longitude, latitude);

        //3、获取该学校推荐的商家
        List<SellerDetail> sellerDetails = sellerService.getAllSellerList(schoolDetail, longitude, latitude);

        logger.info("getAllPartnerList with canteen size: " + canteenDetails.size() + ", seller size: " + sellerDetails.size());
        String result = JsonResponseUtils.partnerResponseJson(canteenDetails, sellerDetails, longitude, latitude);
        logger.info("getAllPartnerList with result: " + result);

        return new SchoolResponse(0, "ok", result);
    }


    /**
     * 获取商品信息
     * @param partnerId 商户ID
     * @return
     */
    @RequestMapping(value = "get_menu_list", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse getMenuList(@RequestParam(required=true,value="partner_id") String partnerId) {
        logger.info("getMenuList with partnerId : " + partnerId);

        SchoolUtils.SellerType sellerType = SchoolUtils.getSellerType(partnerId);

        String result = "";
        if (sellerType == SchoolUtils.SellerType.CANTEEN) {
            List<Menu> menus = canteenService.getMenuList(partnerId);
        }
        else if (sellerType == SchoolUtils.SellerType.SELLER) {
            List<Menu> menus = sellerService.getMenuList(partnerId);
        }
        else
            return new SchoolResponse(-1, "error partner id", result);

        return new SchoolResponse(0, "ok", result);
    }
}
