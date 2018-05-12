package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.school.CanteenDetail;
import com.eliteams.quick4j.web.model.school.SchoolDetail;

import java.awt.*;
import java.util.List;

public interface CanteenService extends GenericService<CanteenDetail, Long> {

    List<CanteenDetail> getRecommandCanteenList(SchoolDetail schoolDetail, double longitude, double latitude);

    List<CanteenDetail> getAllCanteenList(SchoolDetail schoolDetail, double longitude, double latitude);

    List<Menu> getMenuList(String partnerId);
}
