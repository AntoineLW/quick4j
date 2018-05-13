package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.ActionOrder;

public interface ActionOrderMapper extends GenericDao<ActionOrder, Long> {

    ActionOrder selectByOrderId(long orderId,long userId);
}
