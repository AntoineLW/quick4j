package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.model.response.SchoolResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/school_user")
public class SchoolUserController {

    Logger logger  =  Logger.getLogger(SchoolUserController.class);

    /**
     * 获取地址列表
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "get_express_list", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse getExpressList(@RequestParam(required=true,value="user_id") String userId) {
        logger.info("getExpressList with userId : " + userId);
        return new SchoolResponse(0, "ok", "");
    }

    /**
     * 增加地址
     * @param userId 用户ID
     * @param address 地址
     * @param receptorName 接收者姓名
     * @param receptorPhoneNumber 接收者电话
     * @return
     */
    @RequestMapping(value = "add_express_info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse addExpressInfo(@RequestParam(required=true,value="user_id") String userId,
                                         @RequestParam(required=true,value="address") String address,
                                         @RequestParam(required=true,value="receptor_name") String receptorName,
                                         @RequestParam(required=true,value="receptor_phone_number") String receptorPhoneNumber) {
        logger.info("addExpressInfo with userId : " + userId + ", address: " + address + ", receptorName: " + receptorName + ", receptorPhoneNumber:" + receptorPhoneNumber);
        return new SchoolResponse(0, "ok", "");
    }

    /**
     * 更新地址
     * @param userId 用户ID
     * @param expressId 地址ID
     * @param address 地址
     * @param receptorName 接收者姓名
     * @param receptorPhoneNumber 接收者电话
     * @return
     */
    @RequestMapping(value = "update_express_info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse updateExpressInfo(@RequestParam(required=true,value="user_id") String userId,
                                            @RequestParam(required=true,value="express_id") String expressId,
                                            @RequestParam(required=true,value="address") String address,
                                            @RequestParam(required=true,value="receptor_name") String receptorName,
                                            @RequestParam(required=true,value="receptor_phone_number") String receptorPhoneNumber) {
        logger.info("updateExpressInfo with userId : " + userId + ", expressId: " + expressId + ", address: " + address + ", receptorName: " + receptorName + ", receptorPhoneNumber:" + receptorPhoneNumber);
        return new SchoolResponse(0, "ok", "");
    }

    /**
     * 删除地址
     * @param userId 用户ID
     * @param expressId 地址ID
     * @return
     */
    @RequestMapping(value = "delete_express_info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse deleteExpressInfo(@RequestParam(required=true,value="user_id") String userId,
                                            @RequestParam(required=true,value="express_id") String expressId) {
        logger.info("deleteExpressInfo with userId : " + userId + ", expressId: " + expressId);
        return new SchoolResponse(0, "ok", "");
    }
}
