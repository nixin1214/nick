package com.roncoo.adminlte.bean.vo;

import com.roncoo.adminlte.bean.entity.TSysResource;

import java.io.Serializable;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/27 22:13
 */
public class TSysResourceVo implements Serializable {
    private long id;
    private String name;
    private String url;
    private long _parentId;
    private int level;
    private int status;
    private int sortOrder;
    private String fico;
    private String resType;
    private String permistionValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long get_parentId() {
        return _parentId;
    }

    public void set_parentId(long _parentId) {
        this._parentId = _parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getFico() {
        return fico;
    }

    public void setFico(String fico) {
        this.fico = fico;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getPermistionValue() {
        return permistionValue;
    }

    public void setPermistionValue(String permistionValue) {
        this.permistionValue = permistionValue;
    }

    public TSysResourceVo(TSysResource resource) {
        this.id = resource.getFid();
        this.name = resource.getFresName();
        this.url = resource.getFresUrl();
        this._parentId = resource.getFparentId();
        this.level = resource.getFlevel();
        this.status = resource.getFstatus();
        this.sortOrder = resource.getFpos();
        this.fico = resource.getFico();
        this.resType = resource.getFresType();
        this.permistionValue = resource.getFpermissionValue();
    }

    public TSysResourceVo() {
    }
}
