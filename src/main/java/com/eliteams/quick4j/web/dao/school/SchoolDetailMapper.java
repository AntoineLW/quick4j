package com.eliteams.quick4j.web.dao.school;


import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.SchoolDetail;

import java.util.List;

public interface SchoolDetailMapper extends GenericDao<SchoolDetail, Long> {

    SchoolDetail selectBySchoolId(String schoolId);

    List<SchoolDetail> getAllSchoolDetails();
}
