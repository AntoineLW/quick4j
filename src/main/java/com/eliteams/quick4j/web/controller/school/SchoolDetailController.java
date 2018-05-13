package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.SchoolDetailMapper;
import com.eliteams.quick4j.web.model.school.SchoolDetail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/school")
public class SchoolDetailController {

    Logger logger  =  Logger.getLogger(SchoolDetailController.class);

    @Resource
    SchoolDetailMapper schoolDetailMapper;

    @RequestMapping(value = "v1.0/school_detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SchoolDetail queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        SchoolDetail schoolDetail = schoolDetailMapper.selectByPrimaryKey(id);
        return schoolDetail;
    }
}
