package com.roncoo.adminlte.controller.admin;

import com.roncoo.adminlte.bean.entity.TSysUserLogs;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 操作日志
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/17 10:43
 */
@Controller
@RequestMapping(value = "/admin/operationLog", method = RequestMethod.POST)
public class SysUserLogsConstroller extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TSysUserLogsService service;
    @Autowired
    private UserBiz userBiz;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public void list(ModelMap modelMap) {
        modelMap.put("companys", userBiz.findMyCompanys());
    }

    /**
     * 分页查询
     * @param start 开始页
     * @param pageSize 每页条数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param userName 用户名
     * @param ipAddress IP地址
     * @param opType 操作类型
     * @param orgName 组织名称
     * @return
     */
    @ResponseBody
    @RequestMapping(value = PAGE)
    public PageBean<TSysUserLogs> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                               @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                               @RequestParam(value = "startDate", required = false) String startDate,
                                               @RequestParam(value = "endDate", required = false) String endDate,
                                               @RequestParam(value = "userName", required = false) String userName,
                                               @RequestParam(value = "ipAddress", required = false) String ipAddress,
                                               @RequestParam(value = "opType", required = false) String opType,
                                               @RequestParam(value = "orgName", required = false) String orgName) {

        Result<Page<TSysUserLogs>> result = service.listForPage((start / pageSize) + 1, pageSize, startDate, endDate, userName, ipAddress, opType, orgName);
        //记录操作日志
        service.addLog("浏览操作日志", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览操作日志列表");
        if (result.isStatus()) {
            return new PageBean<TSysUserLogs>(result.getResultData());
        }
        return new PageBean<TSysUserLogs>();
    }

    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public void view(ModelMap modelMap, long id) {
        Result<TSysUserLogs> result = service.query(id);
        if (result.isStatus()) {
            //记录操作日志
            service.addLog("浏览操作日志", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览操作日志详情");
            modelMap.put("bean", result.getResultData());
        }
    }
}
