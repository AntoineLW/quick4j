package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.StaffDetailMapper;
import com.eliteams.quick4j.web.model.school.StaffDetail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/staff")
public class StaffDetailController {

    Logger logger  =  Logger.getLogger(StaffDetailController.class);

    @Resource
    StaffDetailMapper staffDetailMapper;

    @RequestMapping(value = "v1.0/seller_detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StaffDetail queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        StaffDetail staffDetail = staffDetailMapper.selectByPrimaryKey(id);
        return staffDetail;
    }
}
