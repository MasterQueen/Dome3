package com.example.demo3.service.impl.expend;

import com.example.demo3.entry.expend.Bonus;
import com.example.demo3.mapper.BonusMapper;
import com.example.demo3.service.expend.Bonus_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Bonus_bill_serviceimp implements Bonus_bill_service {


    @Autowired
    private BonusMapper bonusMapper;


    @Override
    public List getAllBonus() {
        return null;
    }

    @Override
    public List getBonus(Bonus bonus) {
        return bonusMapper.getBonus(bonus);
    }

    @Override
    public List getBonusByBonus_expendAim(String bonus_expendAim) {
        return null;
    }

    @Override
    public List getBonusByBonus_transactor(String bonus_transactor) {
        return null;
    }

    @Override
    public int delectBonusByID(Integer bonus_expendID) {
        return 0;
    }

    @Override
    public int delectBonusByBonus_expendAim(String bonus_expendAim) {
        return 0;
    }

    @Override
    public int updateBonus(Bonus bonus) {
        return 0;
    }

    @Override
    public int insertBonus(Bonus bonus) {
        return 0;
    }
}
