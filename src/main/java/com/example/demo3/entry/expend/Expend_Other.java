package com.example.demo3.entry.expend;

import java.io.Serializable;

public class Expend_Other  implements Serializable {


    private  int other_expendID;
    private  int other_expendMoney;
    private  String other_expendMan;
    private  String other_expendDate;
    private  String expend_transactor;
    private  String other_expendRemark;
    private String other_keyword;

    public int getOther_expendID() {
        return other_expendID;
    }

    public void setOther_expendID(int other_exxpendID) {
        this.other_expendID = other_exxpendID;
    }

    public int getOther_expendMoney() {
        return other_expendMoney;
    }

    public void setOther_expendMoney(int other_expendMoney) {
        this.other_expendMoney = other_expendMoney;
    }

    public String getOther_expendMan() {
        return other_expendMan;
    }

    public void setOther_expendMan(String other_expendMan) {
        this.other_expendMan = other_expendMan;
    }

    public String getOther_expendDate() {
        return other_expendDate;
    }

    public void setOther_expendDate(String other_expendDate) {
        this.other_expendDate = other_expendDate;
    }

    public String getExpend_transactor() {
        return expend_transactor;
    }

    public void setExpend_transactor(String expend_transactor) {
        this.expend_transactor = expend_transactor;
    }

    public String getOther_expendRemark() {
        return other_expendRemark;
    }

    public void setOther_expendRemark(String other_expendRemark) {
        this.other_expendRemark = other_expendRemark;
    }

    public String getOther_keyword() {
        return other_keyword;
    }

    public void setOther_keyword(String other_keyword) {
        this.other_keyword = other_keyword;
    }

    @Override
    public String toString() {
        return "Expend_Other{" +
                "other_exxpendID=" + other_expendID +
                ", other_expendMoney=" + other_expendMoney +
                ", other_expendMan='" + other_expendMan + '\'' +
                ", other_expendDate='" + other_expendDate + '\'' +
                ", expend_transactor='" + expend_transactor + '\'' +
                ", other_expendRemark='" + other_expendRemark + '\'' +
                ", other_keyword='" + other_keyword + '\'' +
                '}';
    }
}
