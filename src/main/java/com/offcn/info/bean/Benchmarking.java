package com.offcn.info.bean;

import java.util.Date;

public class Benchmarking {
    private Integer id;

    private String comname;

    private Double salesAnount;

    private Integer year;

    private String business;

    private String priority;

    private String disadvantage;

    private String status;

    private Integer empCount;

    private Date createtime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public Double getSalesAnount() {
        return salesAnount;
    }

    public void setSalesAnount(Double salesAnount) {
        this.salesAnount = salesAnount;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getDisadvantage() {
        return disadvantage;
    }

    public void setDisadvantage(String disadvantage) {
        this.disadvantage = disadvantage == null ? null : disadvantage.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getEmpCount() {
        return empCount;
    }

    public void setEmpCount(Integer empCount) {
        this.empCount = empCount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}