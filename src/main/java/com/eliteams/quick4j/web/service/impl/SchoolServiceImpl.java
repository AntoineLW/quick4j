package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.core.util.LocationUtils;
import com.eliteams.quick4j.web.dao.school.SchoolDetailMapper;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import com.eliteams.quick4j.web.service.SchoolService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolServiceImpl extends GenericServiceImpl<SchoolDetail, Long> implements SchoolService {

    Logger logger  =  Logger.getLogger(SchoolServiceImpl.class);

    final double MAXDISTANCE = 5000; //范围在5公里之内被认为是有效距离

    @Resource
    SchoolDetailMapper schoolDetailMapper;

    @Override
    public GenericDao<SchoolDetail, Long> getDao() {
        return schoolDetailMapper;
    }

    @Override
    public SchoolDetail getSchoolByLocation(double longitude, double latitude) {

        logger.info("getSchoolByLocation with longitude: " + longitude + ", latitude: " + latitude);

        List<SchoolDetail> schoolDetails = schoolDetailMapper.getAllSchoolDetails();

        logger.info("getSchoolByLocation with size: " + schoolDetails.size());

        SchoolDetail selectedSchool = null;

        double minDistance = MAXDISTANCE;

        //获取距离最短的学校
        for (SchoolDetail schoolDetail : schoolDetails) {
            double schoolLongtitude = LocationUtils.getLongitude(schoolDetail.getSchoolCoordinate());
            double schoolLatitude = LocationUtils.getLatitude(schoolDetail.getSchoolCoordinate());
            logger.info("getSchoolByLocation with schoolLongtitude: " + schoolLongtitude + ", schoolLatitude: " + schoolLatitude);
            double distance = LocationUtils.getDistance(schoolLatitude, schoolLongtitude, latitude, longitude);
            if (distance <= minDistance) {
                minDistance = distance;
                selectedSchool = schoolDetail;
            }
        }

        return selectedSchool;
    }
}
