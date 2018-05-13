package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.web.model.buy.BuyMenu;
import com.eliteams.quick4j.web.model.school.BuyOrder;

import java.util.List;

/**
 * Created by lf on 2018/5/13.
 */
public interface OrderService {
    boolean createOrder(long userId,long partnerId,List<BuyMenu> buyMenuList,long expressId,long time);
    List<BuyOrder> getOrderById(long userId,long mainOrderId);
}
