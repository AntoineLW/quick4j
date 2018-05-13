package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.web.model.school.ExpressInfo;

import java.util.List;

/**
 * Created by lf on 2018/5/13.
 */
public interface ExpressInfoService {

    boolean addInfo(long userId,String address ,String receptorName,String receptorPhonenumber);
    ExpressInfo queryById(long id,long userId);
    List<ExpressInfo> queryByUserId(long userId);
    boolean updateInfo(long id,long userId,String address ,String receptorName,String receptorPhonenumber);
    boolean deleteInfo(long id,long userId);
}
