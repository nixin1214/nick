package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.TSysUserLogs;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 用户操作日志
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/16 14:32
 */
public interface TSysUserLogsService {

    Result<TSysUserLogs> query(long id);

    Result<Integer> save(TSysUserLogs rcRole);

    Result<Integer> update(TSysUserLogs rcRole);

    Result<Integer> delete(long id);

    /**
     * 操作日志分页查询
     *
     * @param pageCurrent 当前页码
     * @param pageSize 每页显示条数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @param userName 用户姓名
     * @param ipAddress IP地址
     * @param opType 操作类型
     * @param orgName 组织名称
     * @return 列表集合
     */
    Result<Page<TSysUserLogs>> listForPage(int pageCurrent, int pageSize, String startDate, String endDate, String userName, String ipAddress, String opType, String orgName);

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
    void addLog(String opType, String resource, String source, String ipAddress, String errorCode, String errorMsg, String remark);

}
