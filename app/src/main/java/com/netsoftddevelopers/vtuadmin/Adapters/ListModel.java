package com.netsoftddevelopers.vtuadmin.Adapters;

public class ListModel {
    private String iD;
    private String planID;
    private String planAmount;
    private String dataSize;
    private String planType;

    public ListModel() {
    }

    public ListModel(String iD, String planID, String planAmount, String dataSize, String planType) {
        this.iD = iD;
        this.planID = planID;
        this.planAmount = planAmount;
        this.dataSize = dataSize;
        this.planType = planType;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
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

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
