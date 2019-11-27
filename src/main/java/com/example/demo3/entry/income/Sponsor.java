package com.example.demo3.entry.income;

import java.io.Serializable;


/**
 * 赞助商类
 */
public class Sponsor implements Serializable {



    private int sponsor_payID;

    private String sponsorName;

    private int sponsorPhone;

    private String sponsor_payDate;

    private int sponsor_payMoney;

    private String sponsor_payRemark;


    @Override
    public String toString() {
        return "Sponsor{" +
                "sponsor_payID=" + sponsor_payID +
                ", sponsorName='" + sponsorName + '\'' +
                ", sponsorPhone=" + sponsorPhone +
                ", sponsor_payDate='" + sponsor_payDate + '\'' +
                ", sponsor_payMoney=" + sponsor_payMoney +
                ", sponsor_payRemark='" + sponsor_payRemark + '\'' +
                '}';
    }

    public int getSponsor_payID() {
        return sponsor_payID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public int getSponsorPhone() {
        return sponsorPhone;
    }

    public String getSponsor_payDate() {
        return sponsor_payDate;
    }

    public int getSponsor_payMoney() {
        return sponsor_payMoney;
    }

    public String getSponsor_payRemark() {
        return sponsor_payRemark;
    }

    public void setSponsor_payID(int sponsor_payID) {
        this.sponsor_payID = sponsor_payID;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public void setSponsorPhone(int sponsorPhone) {
        this.sponsorPhone = sponsorPhone;
    }

    public void setSponsor_payDate(String sponsor_payDate) {
        this.sponsor_payDate = sponsor_payDate;
    }

    public void setSponsor_payMoney(int sponsor_payMoney) {
        this.sponsor_payMoney = sponsor_payMoney;
    }

    public void setSponsor_payRemark(String sponsor_payRemark) {
        this.sponsor_payRemark = sponsor_payRemark;
    }

}
