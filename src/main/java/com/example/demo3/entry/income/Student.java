package com.example.demo3.entry.income;

import java.io.Serializable;

public class Student implements Serializable {


    private int payID;

    private String studentName;

    private int studentAge;

    private String studentSex;

    private String studentParents;

    private int studentPhone;



    private String payDate;

    private int payMoney;

    private String payMan;

    private String payRemark;

    public int getPayID() {
        return payID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public String getStudentParents() {
        return studentParents;
    }

    public int getStudentPhone() {
        return studentPhone;
    }

    public String getPayDate() {
        return payDate;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public String getPayMan() {
        return payMan;
    }

    public String getPayRemark() {
        return payRemark;
    }


    public void setPayID(int payID) {
        this.payID = payID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public void setStudentParents(String studentParents) {
        this.studentParents = studentParents;
    }

    public void setStudentPhone(int studentPhone) {
        this.studentPhone = studentPhone;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    public void setPayMan(String payMan) {
        this.payMan = payMan;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "payID=" + payID +
                ", studentName='" + studentName + '\'' +
                ", studentAge='" + studentAge + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentParents='" + studentParents + '\'' +
                ", studentPhone=" + studentPhone +
                ", payDate='" + payDate + '\'' +
                ", payMoney=" + payMoney +
                ", payMan='" + payMan + '\'' +
                ", payRemark='" + payRemark + '\'' +
                '}';
    }
}
