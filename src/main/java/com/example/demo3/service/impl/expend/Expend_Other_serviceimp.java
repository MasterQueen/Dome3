package com.example.demo3.service.impl.expend;

import com.example.demo3.entry.expend.Expend_Other;
import com.example.demo3.entry.expend.Salary;
import com.example.demo3.mapper.Expend_OtherMapper;
import com.example.demo3.service.expend.Expend_Other_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Expend_Other_serviceimp implements Expend_Other_bill_service {

    @Autowired
    private Expend_OtherMapper expend_otherMapper;

    @Override
    public List<Expend_Other> getExpend_Other_Bill(Expend_Other expend_other) {
        return expend_otherMapper.getExpend_Other_Bill(expend_other);
    }

    @Override
    public List<Expend_Other> getAllExpend_Other_Bill() {
        return expend_otherMapper.getAllExpend_Other_Bill();
    }

    @Override
    public Expend_Other getExpend_Other_BillByID(int other_expendID) {
        return expend_otherMapper.getExpend_Other_BillByID(other_expendID);
    }

    @Override
    public int updateExpend_Other_BillByID(Expend_Other expend_other) {
        return expend_otherMapper.updateExpend_Other_BillByID(expend_other);
    }

    @Override
    public int insertExpend_Other_Bill(Expend_Other expend_other) {
        return expend_otherMapper.insertExpend_Other_Bill(expend_other);
    }
}
