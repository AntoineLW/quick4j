package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.ActionOrderMapper;
import com.eliteams.quick4j.web.model.school.ActionOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/action_order")
public class ActionOrderController {

    Logger logger  =  Logger.getLogger(ActionOrderController.class);

    @Autowired
    ActionOrderMapper actionOrderMapper;

    @RequestMapping(value = "v1.0/buy_order/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ActionOrder queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        ActionOrder actionOrder = actionOrderMapper.selectByPrimaryKey(id);
        return actionOrder;
    }
}
