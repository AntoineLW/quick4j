package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.CanteenDetailMapper;
import com.eliteams.quick4j.web.dao.school.SchoolDetailMapper;
import com.eliteams.quick4j.web.model.school.CanteenDetail;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/canteen")
public class CanteenDetailController {

    Logger logger  =  Logger.getLogger(CanteenDetailController.class);

    @Autowired
    CanteenDetailMapper canteenDetailMapper;

    @RequestMapping(value = "v1.0/canteen_detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CanteenDetail queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        CanteenDetail canteenDetail = canteenDetailMapper.selectByPrimaryKey(id);
        return canteenDetail;
    }
}
