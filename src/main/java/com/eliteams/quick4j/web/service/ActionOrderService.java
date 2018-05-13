package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.web.model.school.ActionOrder;

/**
 * Created by lf on 2018/5/13.
 */
public interface ActionOrderService {
    boolean createOrder(long userId,String actionDesc,long price,int type);
    ActionOrder getActionOrderById(long userId,long orderId);
}
