package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.BuyOrder;

public interface BuyOrderMapper extends GenericDao<BuyOrder, Long> {

    BuyOrder selectByOrderId(String orderId);
}
