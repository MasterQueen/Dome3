package com.example.demo3.entry.expend;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Bonus implements Serializable {


    private String bonus_expendDate;
    private String bonus_expendAim;
    private int bonus_expendMoney;
    private int bonus_expendID;
    private String bonus_expendRemark;
    private String bonus_transactor;

    @Override
    public String toString() {
        return "Bonus{" +
                "bonus_expendDate=" + bonus_expendDate +
                ", bonus_expendaim='" + bonus_expendAim + '\'' +
                ", bonus_expendMoney=" + bonus_expendMoney +
                ", bonus_expendID=" + bonus_expendID +
                ", bonus_expendRemark='" + bonus_expendRemark + '\'' +
                ", bonus_transactor='" + bonus_transactor + '\'' +
                '}';
    }

    public String getBonus_expendDate() {
        return bonus_expendDate;
    }

    public void setBonus_expendDate(String bonus_expendDate) {
        this.bonus_expendDate = bonus_expendDate;
    }

    public String getBonus_expendAim() {
        return bonus_expendAim;
    }

    public void setBonus_expendAim(String bonus_expendAim) {
        this.bonus_expendAim = bonus_expendAim;
    }

    public  int  getBonus_expendMoney() {
        return bonus_expendMoney;
    }

    public void setBonus_expendMoney( int  bonus_expendMoney) {
        this.bonus_expendMoney = bonus_expendMoney;
    }

    public int getBonus_expendID() {
        return bonus_expendID;
    }

    public void setBonus_expendID(int bonus_expendID) {
        this.bonus_expendID = bonus_expendID;
    }

    public String getBonus_expendRemark() {
        return bonus_expendRemark;
    }

    public void setBonus_expendRemark(String bonus_expendRemark) {
        this.bonus_expendRemark = bonus_expendRemark;
    }

    public String getBonus_transactor() {
        return bonus_transactor;
    }

    public void setBonus_transactor(String bonus_transactor) {
        this.bonus_transactor = bonus_transactor;
    }
}
