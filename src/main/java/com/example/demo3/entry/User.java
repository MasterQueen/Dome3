package com.example.demo3.entry;

import java.io.Serializable;

public class User implements Serializable {

    private int ID;

    private String userName;

    private String userPassword;


    private String schoolName;

    private String schoolMaster;

    private String schoolAddress;

    private int schoolPhone;

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolMaster='" + schoolMaster + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", schoolPhone=" + schoolPhone +
                '}';
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolMaster(String schoolMaster) {
        this.schoolMaster = schoolMaster;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public void setSchoolPhone(int schoolPhone) {
        this.schoolPhone = schoolPhone;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolMaster() {
        return schoolMaster;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public int getSchoolPhone() {
        return schoolPhone;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getID() {
        return ID;
    }

}
