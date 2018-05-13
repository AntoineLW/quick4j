package com.eliteams.quick4j.web.enums;

import lombok.AllArgsConstructor;

/**
 * Created by lf on 2018/5/13.
 */
@AllArgsConstructor
public enum OrderStatus {
    initial(0),
    paied(1),
    finished(2),
    canceled(3),
    invalid(4);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
