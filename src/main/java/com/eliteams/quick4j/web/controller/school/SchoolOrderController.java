package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.model.buy.BuyMenu;
import com.eliteams.quick4j.web.model.response.SchoolResponse;
import com.eliteams.quick4j.web.model.school.ActionOrder;
import com.eliteams.quick4j.web.model.school.BuyOrder;
import com.eliteams.quick4j.web.service.ActionOrderService;
import com.eliteams.quick4j.web.service.OrderService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/school_order")
public class SchoolOrderController {

    Logger logger  =  Logger.getLogger(SchoolOrderController.class);

    @Resource
    private OrderService orderService;
    @Resource
    private ActionOrderService actionOrderService;
    /**
     * 创建外卖订单
     * @param userId 用户ID
     * @param menuList 商品列表
     * @param partnerId 商户ID
     * @return
     */
    @RequestMapping(value = "create_buy_order", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public SchoolResponse createBuyOrder(@RequestParam(required=true,value="user_id") long userId,
                                         @RequestParam(required=true,value="menu_list") String menuList,
                                         @RequestParam(required=true,value="partner_id") long partnerId,
                                         @RequestParam(required=true,value="express_id") long expressId,
                                         @RequestParam(required=true,value="time") long time) {
        logger.info("createBuyOrder with userId : " + userId + ", menuList: " + menuList + ", partnerId: " + partnerId);
        Gson gson = new Gson();
        List<BuyMenu> buyMenus = gson.fromJson(menuList,new TypeToken<List<BuyMenu>>() {}.getType());
        boolean ret = orderService.createOrder(userId, partnerId, buyMenus,expressId,time);
        return new SchoolResponse(0, String.valueOf(ret), "");
    }


    /**
     * 获取外卖订单
     * @param userId 用户ID
     * @param orderId 订单ID
     * @return
     */
    @RequestMapping(value = "get_buy_order", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public List<BuyOrder> getBuyOrder(@RequestParam(required=true,value="user_id") long userId,
                                      @RequestParam(required=true,value="order_id") long orderId) {
        logger.info("getBuyOrder with userId : " + userId + ", orderId: " + orderId);
        return orderService.getOrderById(orderId,userId);
    }


    /**
     * 更新订单信息(提交订单之后配送时间和地址不能修改吧。。。暂不实现)
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
    public SchoolResponse createActionOrder(@RequestParam(required=true,value="user_id") long userId,
                                            @RequestParam(required=true,value="action_desc") String actionDesc,
                                            @RequestParam(required=true,value="price") long price,
                                            @RequestParam(required=true,value="type") int type) {
        logger.info("createActionOrder with userId : " + userId + ", actionDesc: " + actionDesc + ", price: " + price + ", type: " + type);
        boolean ret = actionOrderService.createOrder(userId,actionDesc,price,type);
        return new SchoolResponse(0, String.valueOf(ret), "");
    }


    /**
     * 获取代跑腿订单
     * @param userId 用户ID
     * @param orderId 代跑腿订单ID
     * @return
     */
    @RequestMapping(value = "get_action_order", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ActionOrder getActionOrder(@RequestParam(required=true,value="user_id") long userId,
                                         @RequestParam(required=true,value="order_id") long orderId) {
        logger.info("getActionOrder with userId : " + userId + ", orderId: " + orderId);
        return actionOrderService.getActionOrderById(userId, orderId);
    }
}
