package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.core.util.LocationUtils;
import com.eliteams.quick4j.web.dao.school.SchoolDetailMapper;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import com.eliteams.quick4j.web.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolServiceImpl extends GenericServiceImpl<SchoolDetail, Long> implements SchoolService {

    final double MAXDISTANCE = 5000; //范围在5公里之内被认为是有效距离

    @Autowired
    SchoolDetailMapper schoolDetailMapper;

    @Override
    public GenericDao<SchoolDetail, Long> getDao() {
        return schoolDetailMapper;
    }

    @Override
    public SchoolDetail getSchoolByLocation(double longitude, double latitude) {

        List<SchoolDetail> schoolDetails = schoolDetailMapper.getAllSchoolDetails();

        SchoolDetail selectedSchool = null;

        double minDistance = MAXDISTANCE;

        //获取距离最短的学校
        for (SchoolDetail schoolDetail : schoolDetails) {
            double schoolLongtitude = LocationUtils.getLongitude(schoolDetail.getSchoolCoordinate());
            double schoolLatitude = LocationUtils.getLatitude(schoolDetail.getSchoolCoordinate());
            double distance = LocationUtils.getDistance(schoolLatitude, schoolLongtitude, latitude, longitude);
            if (distance <= minDistance) {
                minDistance = distance;
                selectedSchool = schoolDetail;
            }
        }

        return selectedSchool;
    }
}
