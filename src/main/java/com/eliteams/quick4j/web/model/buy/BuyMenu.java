package com.eliteams.quick4j.web.model.buy;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lf on 2018/5/13.
 */
@Data
public class BuyMenu implements Serializable {

    private static final long serialVersionUID = -4451549333709323903L;
    private long menuid;
    private long count;
    private long showPrice;
}
