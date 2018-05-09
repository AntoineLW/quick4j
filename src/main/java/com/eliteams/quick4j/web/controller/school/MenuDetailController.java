package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.CanteenDetailMapper;
import com.eliteams.quick4j.web.dao.school.MenuDetailMapper;
import com.eliteams.quick4j.web.model.school.CanteenDetail;
import com.eliteams.quick4j.web.model.school.MenuDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/menu")
public class MenuDetailController {

    Logger logger  =  Logger.getLogger(MenuDetailController.class);

    @Autowired
    MenuDetailMapper menuDetailMapper;

    @RequestMapping(value = "v1.0/menu_detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MenuDetail queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        MenuDetail menuDetail = menuDetailMapper.selectByPrimaryKey(id);
        return menuDetail;
    }
}
