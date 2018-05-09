package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.StaffDetail;

public interface StaffDetailMapper extends GenericDao<StaffDetail, Long> {

    StaffDetail selectByStaffId(String staffId);
}
