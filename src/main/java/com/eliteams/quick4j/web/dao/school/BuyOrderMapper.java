package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.BuyOrder;

import java.util.List;

public interface BuyOrderMapper extends GenericDao<BuyOrder, Long> {

    //根据主订单id查询所有订单
    List<BuyOrder> selectByOrderId(Long orderId,long userId);
    //根据主订单id查询主订单
    BuyOrder selectMainByOrderId(Long orderId,long userId);
}
