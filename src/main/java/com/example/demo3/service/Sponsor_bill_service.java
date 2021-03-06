package com.example.demo3.service;

import com.example.demo3.entry.income.Sponsor;

import java.util.List;

public interface Sponsor_bill_service {

    /**
     * 根据ID获取
     * @param
     * @return
     */
    Sponsor getSponsorBypayID(int sponsor_payID);

    /**
     * 根据获取名字获取
     * @param
     * @return
     */
    List<Sponsor> getSponsorByName(String  sponsorName);

    /**
     * 获取全部
     * @return
     */
    List<Sponsor> getAllSponsor();

    /**
     * 插入Sponsor
     * @param
     * @return
     */
    boolean insterSponsor(Sponsor sponsor);


    int updateSponsorBill(Sponsor sponsor);

}
