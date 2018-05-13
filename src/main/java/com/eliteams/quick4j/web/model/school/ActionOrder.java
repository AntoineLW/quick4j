package com.eliteams.quick4j.web.model.school;

import lombok.Data;

/**
 * Created by lf on 2018/5/13.
 */
@Data
public class ActionOrder {
    public long id;
    public long orderId;
    public int status;
    public String actionDesc;
    public int actionType;
    public long totalPrice;
    public long distributionPrice;
    public long userId;
    public long distributorId;
    public String extraData1;
    public String extraData2;
    public long createTime;
    public long updateTime;
    public long paidTime;
    public long cancelTime;
    public long finishTime;
}
