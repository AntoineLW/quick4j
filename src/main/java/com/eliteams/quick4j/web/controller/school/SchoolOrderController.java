package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.model.response.SchoolResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/school_order")
public class SchoolOrderController {

    Logger logger  =  Logger.getLogger(SchoolOrderController.class);

    /**
     * 创建外卖订单
     * @param userId 用户ID
     * @param menuList 商品列表
     * @param partnerId 商户ID
     * @return
     */
    @RequestMapping(value = "create_buy_order", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse createBuyOrder(@RequestParam(required=true,value="user_id") String userId,
                                         @RequestParam(required=true,value="menu_list") String menuList,
                                         @RequestParam(required=true,value="partner_id") String partnerId) {
        logger.info("createBuyOrder with userId : " + userId + ", menuList: " + menuList + ", partnerId: " + partnerId);
        return new SchoolResponse(0, "ok", "");
    }


    /**
     * 获取外卖订单
     * @param userId 用户ID
     * @param partnerId 商户ID
     * @return
     */
    @RequestMapping(value = "get_buy_order", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse getBuyOrder(@RequestParam(required=true,value="user_id") String userId,
                                      @RequestParam(required=true,value="partner_id") String partnerId) {
        logger.info("getBuyOrder with userId : " + userId + ", partnerId: " + partnerId);
        return new SchoolResponse(0, "ok", "");
    }


    /**
     * 更新订单信息
     * @param userId 用户ID
     * @param orderId 订单ID
     * @param expressId 地址ID
     * @param time 配送时间
     * @return
     */
    @RequestMapping(value = "update_delivery_express_info", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse updateDeliveryExpressInfo(@RequestParam(required=true,value="user_id") String userId,
                                                    @RequestParam(required=true,value="order_id") String orderId,
                                                    @RequestParam(required=true,value="express_id") String expressId,
                                                    @RequestParam(required=true,value="time") long time) {
        logger.info("updateDeliveryExpressInfo with userId : " + userId + ", orderId: " + orderId + ", expressId: " + expressId + ", time: " + time);
        return new SchoolResponse(0, "ok", "");
    }


    /**
     * 创建代跑腿订单
     * @param userId 用户ID
     * @param actionDesc 代跑腿描述
     * @param price 价格
     * @param type 类型（1校内，2城区）
     * @return
     */
    @RequestMapping(value = "create_action_order", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse createActionOrder(@RequestParam(required=true,value="user_id") String userId,
                                            @RequestParam(required=true,value="action_desc") String actionDesc,
                                            @RequestParam(required=true,value="price") long price,
                                            @RequestParam(required=true,value="type") int type) {
        logger.info("createActionOrder with userId : " + userId + ", actionDesc: " + actionDesc + ", price: " + price + ", type: " + type);
        return new SchoolResponse(0, "ok", "");
    }


    /**
     * 获取代跑腿订单
     * @param userId 用户ID
     * @param orderId 代跑腿订单ID
     * @return
     */
    @RequestMapping(value = "get_action_order", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse getActionOrder(@RequestParam(required=true,value="user_id") String userId,
                                         @RequestParam(required=true,value="order_id") String orderId) {
        logger.info("getActionOrder with userId : " + userId + ", orderId: " + orderId);
        return new SchoolResponse(0, "ok", "");
    }
}
