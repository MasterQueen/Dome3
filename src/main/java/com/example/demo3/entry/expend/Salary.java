package com.example.demo3.entry.expend;

import java.io.Serializable;

public class Salary  implements Serializable {

    private int salary_expendID;

    private int salary_expendMoney;

    private String salary_expendDate;

    private  String salary_expendAim;

    private String salary_expendRemark;

    private String salary_transactor;

    public int getSalary_expendID() {
        return salary_expendID;
    }

    public int getSalary_expendMoney() {
        return salary_expendMoney;
    }

    public String getSalary_expendDate() {
        return salary_expendDate;
    }

    public String getSalary_expendAim() {
        return salary_expendAim;
    }

    public String getSalary_expendRemark() {
        return salary_expendRemark;
    }

    public String getSalary_transactor() {
        return salary_transactor;
    }

    public void setSalary_expendID(int salary_expendID) {
        this.salary_expendID = salary_expendID;
    }

    public void setSalary_expendMoney(int salary_expendMoney) {
        this.salary_expendMoney = salary_expendMoney;
    }

    public void setSalary_expendDate(String salary_expendDate) {
        this.salary_expendDate = salary_expendDate;
    }

    public void setSalary_expendAim(String salary_expendAim) {
        this.salary_expendAim = salary_expendAim;
    }

    public void setSalary_expendRemark(String salary_expendRemark) {
        this.salary_expendRemark = salary_expendRemark;
    }

    public void setSalary_transactor(String salary_transactor) {
        this.salary_transactor = salary_transactor;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary_expendID=" + salary_expendID +
                ", salary_expendMoney=" + salary_expendMoney +
                ", salary_expendDate='" + salary_expendDate + '\'' +
                ", salary_expendAim='" + salary_expendAim + '\'' +
                ", salary_expendRemark='" + salary_expendRemark + '\'' +
                ", salary_transactor='" + salary_transactor + '\'' +
                '}';
    }
}
