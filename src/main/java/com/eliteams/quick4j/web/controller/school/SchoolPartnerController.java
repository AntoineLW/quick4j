package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.model.response.SchoolResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/school_partner")
public class SchoolPartnerController {

    Logger logger  =  Logger.getLogger(SchoolPartnerController.class);

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
        return new SchoolResponse(0, "ok", "");
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
        return new SchoolResponse(0, "ok", "");
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
        return new SchoolResponse(0, "ok", "");
    }
}
