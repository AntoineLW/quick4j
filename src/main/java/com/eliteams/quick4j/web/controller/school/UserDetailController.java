package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.UserDetailMapper;
import com.eliteams.quick4j.web.model.school.UserDetail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserDetailController {

    Logger logger  =  Logger.getLogger(UserDetailController.class);

    @Resource
    UserDetailMapper userDetailMapper;

    @RequestMapping(value = "v1.0/seller_detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDetail queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        UserDetail userDetail = userDetailMapper.selectByPrimaryKey(id);
        return userDetail;
    }
}
