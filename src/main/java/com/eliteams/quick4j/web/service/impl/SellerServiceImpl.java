package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.school.SellerDetailMapper;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import com.eliteams.quick4j.web.model.school.SellerDetail;
import com.eliteams.quick4j.web.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SellerServiceImpl extends GenericServiceImpl<SellerDetail, Long> implements SellerService {

    @Autowired
    SellerDetailMapper sellerDetailMapper;

    @Override
    public GenericDao<SellerDetail, Long> getDao() {
        return sellerDetailMapper;
    }

    @Override
    public List<SellerDetail> getRecommandSellerList(SchoolDetail schoolDetail, double longitude, double latitude) {

        List<SellerDetail> sellerDetails = sellerDetailMapper.getSellerBySchool(schoolDetail.schoolId);

        if (sellerDetails.size() <= 2)
            return sellerDetails;

        //随机取两个
        int i = (int)Math.random()*(sellerDetails.size()+1);
        int j = i;
        while(j==i) {
            j = (int)Math.random()*(sellerDetails.size()+1);
        }

        List<SellerDetail> recommandSellerDetails = new ArrayList<>();
        recommandSellerDetails.add(sellerDetails.get(i));
        recommandSellerDetails.add(sellerDetails.get(j));

        return recommandSellerDetails;
    }

    @Override
    public List<SellerDetail> getAllSellerList(SchoolDetail schoolDetail, double longitude, double latitude) {
        return sellerDetailMapper.getSellerBySchool(schoolDetail.schoolId);
    }

    @Override
    public List<Menu> getMenuList(String partnerId) {
        return null;
    }
}
