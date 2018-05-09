package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.BuyOrderMapper;
import com.eliteams.quick4j.web.model.school.BuyOrder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/buy_order")
public class BuyOrderController {

    Logger logger  =  Logger.getLogger(BuyOrderController.class);

    @Autowired
    BuyOrderMapper buyOrderMapper;

    @RequestMapping(value = "v1.0/buy_order/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BuyOrder queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        BuyOrder buyOrder = buyOrderMapper.selectByPrimaryKey(id);
        return buyOrder;
    }
}
