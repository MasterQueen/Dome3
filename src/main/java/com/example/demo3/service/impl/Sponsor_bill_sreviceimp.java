package com.example.demo3.service.impl;

import com.example.demo3.entry.income.Sponsor;
import com.example.demo3.mapper.SponsorMapper;
import com.example.demo3.service.Sponsor_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sponsor_bill_sreviceimp implements Sponsor_bill_service {

    @Autowired
    SponsorMapper sponsorMapper;

    @Override
    public Sponsor getSponsorBypayID(int sponsor_payID) {
        return sponsorMapper.getSponsorBypayID(sponsor_payID);
    }

    @Override
    public List<Sponsor> getSponsorByName(String sponsorName) {
        return sponsorMapper.getSponsorByName(sponsorName);
    }

    @Override
    public List<Sponsor> getAllSponsor() {
        return sponsorMapper.getAllSponsor();
    }

    @Override
    public boolean insterSponsor(Sponsor sponsor) {
        return sponsorMapper.insterSponsor(sponsor);
    }

    @Override
    public int updateSponsorBill(Sponsor sponsor) {
        return sponsorMapper.updateSponsorBill(sponsor);
    }
}
