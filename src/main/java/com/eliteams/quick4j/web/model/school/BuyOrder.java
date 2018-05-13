package com.eliteams.quick4j.web.model.school;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lf on 2018/5/13.
 */
@Data
public class BuyOrder implements Serializable{
    private static final long serialVersionUID = 139300363640661345L;
    public long id;
    public long orderId;
    public long expressId;
    public String traceId;
    public int status;
    public long belongCanteen;
    public long belongSeller;
    public long totalPrice;
    public long totalCount;
    public long distributionPrice;
    public long menuId;
    public long userId;
    public long distributorId;
    public String extraData1;
    public String extraData2;
    public long createTime;
    public long updateTime;
    public long paidTime;
    public long cancelTime;
    public long finishTime;
    public long sendTime;
}
