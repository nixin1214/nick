package com.roncoo.adminlte.service.impl;

import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TSysUserLogs;
import com.roncoo.adminlte.bean.entity.TSysUserLogsExample;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.service.impl.dao.TSysUserLogsDao;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 操作日志业务实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/16 15:01
 */
@Service
public class TSysUserLogsServiceImpl implements TSysUserLogsService {
    private static Logger logger = LoggerFactory.getLogger(TSysUserLogsServiceImpl.class);
    @Autowired
    private TSysUserLogsDao dao;

    @Override
    public Result<TSysUserLogs> query(long id) {
        Result<TSysUserLogs> result = new Result<>();
        if (id < 0) {
            result.setErrMsg("此ID无效");
            return result;
        }
        TSysUserLogs userLogs = dao.selectById(id);
        if (userLogs != null) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setResultData(userLogs);
        }
        return result;
    }

    @Override
    public Result<Integer> save(TSysUserLogs userLogs) {
        Result<Integer> result = new Result<>();
        validation(userLogs, result);
        if (StringUtils.isNotEmpty(result.getErrMsg())) {
            return result;
        }
        if (userLogs.getFid() != null) {
            result.setResultData(dao.update(userLogs));
        } else {
            result.setResultData(dao.insert(userLogs));
        }
        return result;
    }

    private void validation(TSysUserLogs userLogs, Result<Integer> result) {
        if (userLogs == null) {
            result.setErrMsg("对象为空，保存失败");
        } else if (StringUtils.isEmpty(userLogs.getFuserName())) {
            result.setErrMsg("用户姓名不能为空");
        } else if (StringUtils.isEmpty(userLogs.getFoperationType())) {
            result.setErrMsg("操作类型不能为空");
        } else if (StringUtils.isEmpty(userLogs.getFresource())) {
            result.setErrMsg("操作资源对象不能为空");
        } else if (StringUtils.isEmpty(userLogs.getFsource())) {
            result.setErrMsg("用户终端来源不能为空");
        }
    }

    @Override
    public Result<Integer> update(TSysUserLogs userLogs) {
        Result<Integer> result = new Result<>();
        validation(userLogs, result);
        if (StringUtils.isNotEmpty(result.getErrMsg())) {
            return result;
        }
        if (userLogs.getFid() == null) {
            result.setErrMsg("ID不能为空");
            return result;
        }
        result.setResultData(dao.update(userLogs));
        return result;
    }

    @Override
    public Result<Integer> delete(long id) {
        Result<Integer> result = new Result<>();
        if (id <= 0) {
            result.setErrMsg("ID不能为空");
            return result;
        }
        result.setResultData(dao.deleteById(id));
        return result;
    }

    @Override
    public Result<Page<TSysUserLogs>> listForPage(int pageCurrent, int pageSize, String startDate, String endDate, String userName, String ipAddress, String opType, String orgName) {
        TSysUserLogsExample example = new TSysUserLogsExample();
        TSysUserLogsExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(startDate)) {
            criteria.andFcreatimeGreaterThanOrEqualTo(DateUtil.parseDate(startDate));
        }
        if (StringUtils.isNotEmpty(endDate)) {
            criteria.andFcreatimeLessThanOrEqualTo(DateUtil.parseDate(endDate));
        }
        if (StringUtils.isNotEmpty(userName)) {
            criteria.andFuserAccountLike(SqlUtil.like(userName));
        }
        if (StringUtils.isNotEmpty(ipAddress)) {
            criteria.andFipAddressEqualTo(SqlUtil.like(ipAddress));
        }
        if (StringUtils.isNotEmpty(opType)) {
            criteria.andFoperationTypeEqualTo(opType);
        }
        if (StringUtils.isNotEmpty(orgName)) {
            criteria.andFuserOrgNameEqualTo(orgName);
        }
        Result<Page<TSysUserLogs>> result = new Result<>();
        Page<TSysUserLogs> resultList = dao.listForPage(pageCurrent, pageSize, example);
        if (resultList != null) {
            result.setStatus(true);
            result.setResultData(resultList);
        } else {
            result.setErrMsg("未找到匹配的记录！");
        }
        return result;
    }

    /**
     * 添加操作日志
     *
     * @param opType 操作类型
     * @param resource 操作对象
     * @param source 操作来源
     * @param ipAddress IP地址
     * @param errorCode 错误码
     * @param errorMsg 错误描述
     * @param remark 备注
     */
    public void addLog(String opType, String resource, String source, String ipAddress, String errorCode, String errorMsg, String remark) {
        Session session = SecurityUtils.getSubject().getSession();

        try {
            RcUser user = (RcUser) session.getAttribute(Constants.Token.USER_INFO);
            if (user == null) {
                return;
            }
            TSysUserLogs userLogs = new TSysUserLogs();
            userLogs.setFcreatime(new Date());
            userLogs.setFerrorCode(errorCode);
            userLogs.setFerrorMsg(errorMsg);
            userLogs.setFipAddress(ipAddress);
            userLogs.setFoperationType(opType);
            userLogs.setFremark(remark);
            userLogs.setFresource(resource);
            userLogs.setFsource(source);
            userLogs.setFstatus("成功");
            userLogs.setFuserId(user.getId());
            userLogs.setFuserName(user.getNickName());
            userLogs.setFuserAccount(user.getUserNo());
            userLogs.setFuserOrgName(user.getDataScope());
            Result<Integer> result = save(userLogs);
            if (result.isStatus()) {
                logger.debug("add operation log success, logInfo:{}", userLogs);
            } else {
                logger.error("add operation log fail, error msg: {}, logInfo:{}", result.getErrMsg(), userLogs);
            }
        } catch (InvalidSessionException e) {
            logger.error("invalid session, add operation log fail!");
        } catch (Exception e) {
            logger.error("add operation log fail, error msg: {}", e.getMessage(), e);
        }
    }
}
