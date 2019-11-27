package com.example.demo3.mapper;

import com.example.demo3.entry.expend.Bonus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public interface BonusMapper {

    /**
     * 获取所有Bonus信息
     * @return
     */
    List getAllBonus();

    /**
     *
     * 获取Bonus
     * @param
     * @return
     */
    List<Map<String,Object>> getBonusBy(Map bonus);

    /**
     * 根据分红目标对象获取Bonus
     * @param bonus
     * @return
     */
    List getBonus(Bonus bonus);

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
