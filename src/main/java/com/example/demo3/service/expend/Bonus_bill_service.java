package com.example.demo3.service.expend;

import com.example.demo3.entry.expend.Bonus;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Map;

public interface Bonus_bill_service {

    /**
     * 获取所有Bonus信息
     * @return
     */
    List <Bonus>getAllBonus();

    /**
     *
     * 获取Bonus
     * @param
     * @return
     */
    List <Bonus>getBonus(Bonus bonus);

    /**
     * 根据ID获取bonus
     * @param bonus_expendID
     * @return
     */
    Bonus getBonusById(Integer bonus_expendID);
    /**
     * 根据分红目标对象获取Bonus
     * @param bonus_expendAim
     * @return
     */
    List getBonusByBonus_expendAim(String bonus_expendAim);

    /**
     * 根据办理人获取Bonus
     * @param bonus_transactor
     * @return
     */
    List getBonusByBonus_transactor(String bonus_transactor);

    /**
     * 根据ID删除
     * @param bonus_expendID
     * @return
     */
    int delectBonusByID(Integer bonus_expendID);

    /**
     * 根据目标对象删除
     * @param bonus_expendAim
     * @return
     */
    int delectBonusByBonus_expendAim(String bonus_expendAim);

    /**
     * 更新Bonus
     * @param bonus
     * @return
     */
    int updateBonus(Bonus bonus);

    /**
     * 添加Bonus
     * @param bonus
     * @return
     */

    int insertBonus(Bonus bonus);


}
