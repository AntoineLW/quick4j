package com.eliteams.quick4j.web.model.school;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by lf on 2018/5/13.
 */
@Data
@NoArgsConstructor
public class ExpressInfo {
    private long id;
    private long userId;
    private String address;
    private String receptorName;
    private String receptorPhonenumber;
    private String extraData1;
    private String extraData2;
    private long createTime;
    private long updateTime;

    public ExpressInfo(long id, long userId, String address, String receptorName, String receptorPhonenumber) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.receptorName = receptorName;
        this.receptorPhonenumber = receptorPhonenumber;
    }
}
