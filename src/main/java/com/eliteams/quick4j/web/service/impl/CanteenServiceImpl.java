package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.school.CanteenDetailMapper;
import com.eliteams.quick4j.web.model.school.CanteenDetail;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import com.eliteams.quick4j.web.service.CanteenService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CanteenServiceImpl extends GenericServiceImpl<CanteenDetail, Long> implements CanteenService {

    Logger logger  =  Logger.getLogger(CanteenServiceImpl.class);

    @Resource
    private CanteenDetailMapper canteenDetailMapper;

    @Override
    public GenericDao<CanteenDetail, Long> getDao() {
        return canteenDetailMapper;
    }

    @Override
    public List<CanteenDetail> getRecommandCanteenList(SchoolDetail schoolDetail, double longitude, double latitude) {

        List<CanteenDetail> canteenDetails = canteenDetailMapper.getCanteensBySchool(schoolDetail.schoolId);

        if (canteenDetails.size() <= 2)
            return canteenDetails;

        //随机取两个
        int i = (int)Math.random()*(canteenDetails.size()+1);
        int j = i;
        while(j==i) {
            j = (int)Math.random()*(canteenDetails.size()+1);
        }

        List<CanteenDetail> recommandCanteenDetails = new ArrayList<>();
        recommandCanteenDetails.add(canteenDetails.get(i));
        recommandCanteenDetails.add(canteenDetails.get(j));

        return recommandCanteenDetails;
    }

    @Override
    public List<CanteenDetail> getAllCanteenList(SchoolDetail schoolDetail, double longitude, double latitude) {
        logger.info("getAllCanteenList with schoolId: " + schoolDetail.schoolId + ", longitude: " + longitude + ", latitude:" + latitude);
        return canteenDetailMapper.getCanteensBySchool(schoolDetail.schoolId);
    }

    @Override
    public List<Menu> getMenuList(String partnerId) {
        return null;
    }
}
