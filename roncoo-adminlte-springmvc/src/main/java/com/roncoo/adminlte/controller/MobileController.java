package com.roncoo.adminlte.controller;

import com.roncoo.adminlte.util.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 移动端控制类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2018/1/11 17:50
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public void getIndex(ModelMap modelMap, HttpServletRequest request) {
        getBaseInfo(modelMap);


    }
}
