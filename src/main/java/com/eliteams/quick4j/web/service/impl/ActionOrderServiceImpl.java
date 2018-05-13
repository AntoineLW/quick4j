package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.school.ActionOrderMapper;
import com.eliteams.quick4j.web.dao.school.BuyOrderMapper;
import com.eliteams.quick4j.web.model.school.ActionOrder;
import com.eliteams.quick4j.web.model.school.BuyOrder;
import com.eliteams.quick4j.web.service.ActionOrderService;

import javax.annotation.Resource;

/**
 * Created by lf on 2018/5/13.
 */
public class ActionOrderServiceImpl extends GenericServiceImpl<ActionOrder, Long> implements ActionOrderService{
    @Resource
    private ActionOrderMapper actionOrderMapper;


    @Override
    public GenericDao<ActionOrder, Long> getDao() {
        return actionOrderMapper;
    }

    @Override
    public boolean createOrder(long userId, String actionDesc, long price, int type) {
        ActionOrder actionOrder = new ActionOrder();
        actionOrder.setUserId(userId);
        actionOrder.setActionDesc(actionDesc);
        actionOrder.setActionType(type);
        actionOrder.setTotalPrice(price);
        actionOrder.setCreateTime(System.currentTimeMillis());
        actionOrder.setUpdateTime(System.currentTimeMillis());
        return 1 == actionOrderMapper.insertSelective(actionOrder);
    }

    @Override
    public ActionOrder getActionOrderById(long userId, long orderId) {
        return actionOrderMapper.selectByOrderId(orderId,userId);
    }
}
