package com.roncoo.adminlte.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class TSysRoleResource implements Serializable {
    private Long fid;

    private Long froleId;

    private Long fresourceId;

    private Date fcreatime;

    private Date fupdatime;

    private static final long serialVersionUID = 1L;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFroleId() {
        return froleId;
    }

    public void setFroleId(Long froleId) {
        this.froleId = froleId;
    }

    public Long getFresourceId() {
        return fresourceId;
    }

    public void setFresourceId(Long fresourceId) {
        this.fresourceId = fresourceId;
    }

    public Date getFcreatime() {
        return fcreatime;
    }

    public void setFcreatime(Date fcreatime) {
        this.fcreatime = fcreatime;
    }

    public Date getFupdatime() {
        return fupdatime;
    }

    public void setFupdatime(Date fupdatime) {
        this.fupdatime = fupdatime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", froleId=").append(froleId);
        sb.append(", fresourceId=").append(fresourceId);
        sb.append(", fcreatime=").append(fcreatime);
        sb.append(", fupdatime=").append(fupdatime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}