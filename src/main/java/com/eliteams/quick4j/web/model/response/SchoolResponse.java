package com.eliteams.quick4j.web.model.response;

/**
 * Created by mi on 18-5-10.
 */
public class SchoolResponse {

    private int rtnCode = 0;
    private String rtnMsg = "";
    private String data = "";

    public SchoolResponse(int rtnCode, String rtnMsg, String data) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
        this.data =  data;
    }

    public void setRtnCode(int rtnCode) { this.rtnCode = rtnCode; }
    public int getRtnCode() { return this.rtnCode; }

    public void setRtnMsg(String rtnMsg) { this.rtnMsg = rtnMsg; }
    public String getRtnMsg() { return this.rtnMsg; }

    public void setData(String data) { this.data = data; }
    public String getData() { return this.data; }
}
