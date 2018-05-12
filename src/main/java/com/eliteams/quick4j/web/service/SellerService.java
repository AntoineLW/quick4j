package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.generic.GenericService;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import com.eliteams.quick4j.web.model.school.SellerDetail;

import java.awt.*;
import java.util.List;

public interface SellerService extends GenericService<SellerDetail, Long> {

    List<SellerDetail> getRecommandSellerList(SchoolDetail schoolDetail, double longitude, double latitude);

    List<SellerDetail> getAllSellerList(SchoolDetail schoolDetail, double longitude, double latitude);

    List<Menu> getMenuList(String partnerId);
}
