package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.UserMapper;
import com.eliteams.quick4j.web.dao.school.ExpressInfoMapper;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.model.school.ExpressInfo;
import com.eliteams.quick4j.web.service.ExpressInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lf on 2018/5/13.
 * 物流信息管理处理
 */
public class ExpressInfoServiceImpl extends GenericServiceImpl<ExpressInfo, Long>  implements ExpressInfoService {
    @Resource
    private ExpressInfoMapper expressInfoMapper;

    @Override
    public GenericDao<ExpressInfo, Long> getDao() {
        return expressInfoMapper;
    }

    @Override
    public boolean addInfo(long userId, String address, String receptorName, String receptorPhonenumber) {
        ExpressInfo expressInfo = new ExpressInfo();
        expressInfo.setUserId(userId);
        expressInfo.setAddress(address);
        expressInfo.setReceptorName(receptorName);
        expressInfo.setReceptorPhonenumber(receptorPhonenumber);
        expressInfo.setExtraData1(null);
        expressInfo.setExtraData2(null);
        expressInfo.setCreateTime(System.currentTimeMillis());
        expressInfo.setUpdateTime(System.currentTimeMillis());
        return 1 == expressInfoMapper.insertSelective(expressInfo);
    }

    @Override
    public ExpressInfo queryById(long id, long userId) {
        return expressInfoMapper.selectById(id, userId);
    }

    @Override
    public List<ExpressInfo> queryByUserId(long userId) {
        return expressInfoMapper.selectByUserId(userId);
    }

    @Override
    public boolean updateInfo(long id, long userId, String address, String receptorName, String receptorPhonenumber) {
        ExpressInfo info = new ExpressInfo(id,userId,address,receptorName,receptorPhonenumber);
        return 1 == expressInfoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public boolean deleteInfo(long id, long userId) {
        return 1 == expressInfoMapper.deleteById(id,userId);
    }
}
