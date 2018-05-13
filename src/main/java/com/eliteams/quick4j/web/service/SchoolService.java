package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.school.SchoolDetail;

public interface SchoolService extends GenericService<SchoolDetail, Long> {

    SchoolDetail getSchoolByLocation(double longitude, double latitude);
}
