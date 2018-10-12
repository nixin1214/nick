package com.roncoo.adminlte.controller.report;

import com.roncoo.adminlte.service.BusinessQuotaService;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.util.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务指标控制器
 *
 * @Description: 各类业务指标查询入口
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/31 11:45
 */
@Controller
@RequestMapping(value = "report/quota")
public class BusinessQuotaController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessQuotaService businessQuotaService;
    @Autowired
    private TSysUserLogsService userLogsService;

    //TODO  以下根据业务指标做相应接口
}
