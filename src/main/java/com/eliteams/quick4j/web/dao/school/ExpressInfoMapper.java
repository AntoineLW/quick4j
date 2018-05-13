package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.ExpressInfo;

import java.util.List;

/**
 * Created by lf on 2018/5/13.
 */
public interface ExpressInfoMapper extends GenericDao<ExpressInfo, Long> {

    List<ExpressInfo> selectByUserId(long userId);

    ExpressInfo selectById(long id,long userId);

    int deleteById(long id,long userId);

}
