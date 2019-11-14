package com.example.demo3.mapper;


import com.example.demo3.entry.Income_Other;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Income_OtherMapper {

    /**
     * 获取素有其他收入列表
     * @return
     */
    List<Income_Other> getAll();

    /**
     * 根据pay_ID获取其他收入信息
     * @param other_payID
     * @return
     */
    Income_Other getIncome_OtheByPayId(int other_payID);

    /***
     * 更新incom_other信息
     * @param income_other
     * @return
     */
    int updateIncome_Other(Income_Other income_other);

    /**
     * 根据payID删除其他收入信息
     * @param other_payID
     * @return
     */
    int delectIncome_OtherByPayId(int other_payID);

    /**
     * 添加信息的其他收入信息
     * @param income_other
     * @return
     */
    int insertIncome_Other(Income_Other income_other);


}