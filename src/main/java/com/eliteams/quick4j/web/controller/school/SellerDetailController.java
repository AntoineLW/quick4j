package com.eliteams.quick4j.web.controller.school;

import com.eliteams.quick4j.web.dao.school.SellerDetailMapper;
import com.eliteams.quick4j.web.model.school.SellerDetail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/seller")
public class SellerDetailController {

    Logger logger  =  Logger.getLogger(SellerDetailController.class);

    @Resource
    SellerDetailMapper sellerDetailMapper;

    @RequestMapping(value = "v1.0/seller_detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SellerDetail queryById(@PathVariable long id, HttpServletRequest request) {
        logger.info("queryById with id : " + id);
        SellerDetail sellerDetail = sellerDetailMapper.selectByPrimaryKey(id);
        return sellerDetail;
    }
}
