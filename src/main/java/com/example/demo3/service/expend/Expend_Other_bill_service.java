package com.example.demo3.service.expend;

import com.example.demo3.entry.expend.Expend_Other;
import com.example.demo3.entry.expend.Salary;

import java.util.List;

public interface Expend_Other_bill_service {


    /**
     * 获取所有工资支出信息
     * @param expend_other
     * @return
     */
    List<Expend_Other> getExpend_Other_Bill(Expend_Other expend_other);


    /**
     * 根据条件获取工资支出信息
     * @return
     */
    List<Expend_Other> getAllExpend_Other_Bill();

    /**
     * 根据ID获取支出工资信息
     * @param other_expendID
     * @return
     */
    Expend_Other getExpend_Other_BillByID(int other_expendID);

    /**
     * 根据ID更新工资支出信息
     * @param expend_other
     * @return
     */
    int updateExpend_Other_BillByID(Expend_Other expend_other);

    /**
     * 添加工资支出信息
     * @param expend_other
     * @return
     */
    int insertExpend_Other_Bill(Expend_Other expend_other);


}
