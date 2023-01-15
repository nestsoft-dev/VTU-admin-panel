package com.netsoftddevelopers.vtuadmin.Adapters;


public class DataItem {
    private String iD;
    private String planDuration;
    private String planAmount;
    private String dataSize;
    private String planId;

    public DataItem(String iD, String planDuration, String planAmount, String dataSize, String planId) {
        this.iD = iD;
        this.planDuration = planDuration;
        this.planAmount = planAmount;
        this.dataSize = dataSize;
        this.planId = planId;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(String planDuration) {
        this.planDuration = planDuration;
    }

    public String getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(String planAmount) {
        this.planAmount = planAmount;
    }

    public String getDataSize() {
        return dataSize;
    }

    public void setDataSize(String dataSize) {
        this.dataSize = dataSize;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
