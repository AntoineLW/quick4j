package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.web.model.school.SchoolDetail;

/**
 * Created by mi on 18-5-11.
 */
public interface SchoolService {

    SchoolDetail getSchoolByLocation(double longitude, double latitude);
}
