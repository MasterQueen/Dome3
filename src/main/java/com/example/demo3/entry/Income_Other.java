package com.example.demo3.entry;

import java.io.Serializable;

public class Income_Other implements Serializable {


    private int other_payID;

    private String other_payDate;

    private int other_payMoney;

    private String other_payRemark;

    public int getOther_payID() {
        return other_payID;
    }

    public String getOther_payDate() {
        return other_payDate;
    }

    public int getOther_payMoney() {
        return other_payMoney;
    }

    public String getOther_payRemark() {
        return other_payRemark;
    }

    public void setOther_payID(int other_payID) {
        this.other_payID = other_payID;
    }

    public void setOther_payDate(String other_payDate) {
        this.other_payDate = other_payDate;
    }

    public void setOther_payMoney(int other_payMoney) {
        this.other_payMoney = other_payMoney;
    }

    public void setOther_payRemark(String other_payRemark) {
        this.other_payRemark = other_payRemark;
    }

    @Override
    public String toString() {
        return "Income_Other{" +
                "other_payID=" + other_payID +
                ", other_payDate='" + other_payDate + '\'' +
                ", other_payMoney=" + other_payMoney +
                ", other_payRemark='" + other_payRemark + '\'' +
                '}';
    }
}
