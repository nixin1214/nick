package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class RcUser implements Serializable {
    private Long id;

    private String statusId;

    private Date createTime;

    private Date updateTime;

    private String userNo;

    private String password;

    private String nickName;

    private Integer sex;

    private String viewType;

    private String dataScope;

    private String isMobile;
    private String YZJOpenId;

    private static final long serialVersionUID = 1L;

    private RcCompany company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId == null ? null : statusId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile;
    }

    public String getYZJOpenId() {
        return YZJOpenId;
    }

    public void setYZJOpenId(String YZJOpenId) {
        this.YZJOpenId = YZJOpenId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", statusId=").append(statusId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userNo=").append(userNo);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickName);
        sb.append(", sex=").append(sex);
        sb.append(", viewType=").append(viewType);
        sb.append(", dataScope=").append(dataScope);
        sb.append(", isMobile=").append(isMobile);
        sb.append(", yzjOpenId=").append(YZJOpenId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    public RcUser() {

    }

    public RcUser(RcUser rcUser) {
        this.id = rcUser.getId();
        this.statusId = rcUser.getStatusId();
        this.createTime = rcUser.getCreateTime();
        this.updateTime = rcUser.getUpdateTime();
        this.userNo = rcUser.getUserNo();
        this.password = rcUser.getPassword();
        this.nickName = rcUser.getNickName();
        this.sex = rcUser.getSex();
        this.viewType = rcUser.getViewType();
        this.dataScope = rcUser.getDataScope();
    }

    public RcCompany getCompany() {
        return company;
    }

    public void setCompany(RcCompany company) {
        this.company = company;
    }
}