package com.example.demo3.service.impl;

import com.example.demo3.entry.income.Income_Other;
import com.example.demo3.mapper.Income_OtherMapper;
import com.example.demo3.service.Income_Other_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 其他收入service
 */
@Service
public class Income_Other_bill_serviceimp implements Income_Other_bill_service {

    @Autowired
    Income_OtherMapper income_otherMapper;

    @Override
    public List<Income_Other> getAll() {
        return income_otherMapper.getAll();
    }

    @Override
    public Income_Other getIncome_OtheByPayId(int other_payID) {
        return income_otherMapper.getIncome_OtheByPayId(other_payID);
    }

    @Override
    public int updateIncome_Other(Income_Other income_other) {
        return income_otherMapper.updateIncome_Other(income_other);
    }

    @Override
    public int delectIncome_OtherByPayId(int other_payID) {
        return income_otherMapper.delectIncome_OtherByPayId(other_payID);
    }

    @Override
    public int insertIncome_Other(Income_Other income_other) {
        return income_otherMapper.insertIncome_Other(income_other);
    }

    @Override
    public  List getIncome_OtherByOther_payMan(String other_payMan) {
        return income_otherMapper.getIncome_OtherByOther_payMan(other_payMan);
    }
}
