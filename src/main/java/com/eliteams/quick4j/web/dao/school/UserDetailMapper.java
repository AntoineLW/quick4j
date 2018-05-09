package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.UserDetail;

public interface UserDetailMapper extends GenericDao<UserDetail, Long> {

    UserDetail selectByUserId(String userId);
}
