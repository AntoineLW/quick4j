package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.PermissionMapper;
import com.eliteams.quick4j.web.dao.school.BuyOrderMapper;
import com.eliteams.quick4j.web.enums.OrderStatus;
import com.eliteams.quick4j.web.model.Permission;
import com.eliteams.quick4j.web.model.buy.BuyMenu;
import com.eliteams.quick4j.web.model.school.BuyOrder;
import com.eliteams.quick4j.web.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lf on 2018/5/13.
 */
@Service
@Slf4j
public class OrderServiceImpl extends GenericServiceImpl<BuyOrder, Long>  implements OrderService{

    @Resource
    private BuyOrderMapper buyOrderMapper;


    @Override
    public GenericDao<BuyOrder, Long> getDao() {
        return buyOrderMapper;
    }

    @Override
    public boolean createOrder(long userId, long partnerId, List<BuyMenu> buyMenuList,long expressId,long time) {
        log.info("createOrder , userid = " + userId + " partnerId = " + partnerId);
        try {
            BuyOrder mainOrder = buildMainOrder(userId,partnerId,buyMenuList,expressId,time);
            long orderId = buyOrderMapper.insertSelective(mainOrder);
            List<BuyOrder> subOrders = buildSubOrder(userId,partnerId,buyMenuList,orderId,mainOrder.getTraceId());
            for (BuyOrder buyOrder : subOrders){
                buyOrderMapper.insertSelective(buyOrder);
            }
            return true;
        }catch (Throwable e){
            log.error("createOrder error",e);
            return false;
        }
    }

    @Override
    public List<BuyOrder> getOrderById(long userId, long mainOrderId) {
        return buyOrderMapper.selectByOrderId(mainOrderId,userId);
    }

    private static BuyOrder buildMainOrder(long userId, long partnerId, List<BuyMenu> buyMenuList,long expressId,long time){
        BuyOrder mainOrder = new BuyOrder();
        mainOrder.setExpressId(expressId);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(userId).append(partnerId).append(System.currentTimeMillis());
        mainOrder.setTraceId(stringBuffer.toString());
        mainOrder.setBelongSeller(partnerId);
        mainOrder.setUserId(userId);
        mainOrder.setCreateTime(System.currentTimeMillis());
        mainOrder.setUpdateTime(System.currentTimeMillis());
        mainOrder.setSendTime(time);
        mainOrder.setStatus(OrderStatus.initial.getCode());
        long totalPrice = 0L;
        long totalCount = 0L;
        for (BuyMenu buyMenu : buyMenuList){
            totalPrice += buyMenu.getShowPrice() * buyMenu.getCount();
            totalCount += buyMenu.getCount();
        }
        mainOrder.setMenuId(-1);
        mainOrder.setTotalPrice(totalPrice);
        mainOrder.setTotalCount(totalCount);
        return mainOrder;
    }

    private static List<BuyOrder> buildSubOrder(long userId, long partnerId, List<BuyMenu> buyMenuList,long mainOrderId,String traceId){
        List<BuyOrder> ret = new ArrayList<>();
        for (BuyMenu buyMenu : buyMenuList){
            BuyOrder subOrder = new BuyOrder();
            subOrder.setOrderId(mainOrderId);
            subOrder.setTraceId(traceId);
            subOrder.setBelongSeller(partnerId);
            subOrder.setUserId(userId);
            subOrder.setCreateTime(System.currentTimeMillis());
            subOrder.setUpdateTime(System.currentTimeMillis());
            subOrder.setStatus(OrderStatus.initial.getCode());

            subOrder.setMenuId(buyMenu.getMenuid());
            subOrder.setTotalPrice(buyMenu.getShowPrice() * buyMenu.getCount());
            subOrder.setTotalCount(buyMenu.getCount());
            ret.add(subOrder);
        }
        return ret;
    }
}
