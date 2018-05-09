package com.eliteams.quick4j.web.dao.school;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.school.MenuDetail;

/**
 * Created by mi on 18-5-9.
 */
public interface MenuDetailMapper extends GenericDao<MenuDetail, Long> {

    MenuDetail selectByMenuId(String menuId);
}
