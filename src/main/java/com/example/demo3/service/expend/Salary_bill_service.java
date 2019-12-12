package com.example.demo3.service.expend;

import com.example.demo3.entry.expend.Salary;

import java.util.List;

public interface Salary_bill_service {


    /**
     * 获取所有工资支出信息
     * @param salary
     * @return
     */
    List<Salary> getSalary_Bill(Salary salary);


    /**
     * 根据条件获取工资支出信息
     * @return
     */
    List<Salary> getAllSalary_Bill();

    /**
     * 根据ID获取支出工资信息
     * @param salary_expendID
     * @return
     */
    Salary getSalary_BillByID(int salary_expendID);

    /**
     * 根据ID更新工资支出信息
     * @param salary
     * @return
     */
    int updateSalary_BillByID(Salary salary);

    /**
     * 添加工资支出信息
     * @param salary
     * @return
     */
    int insertSalary_Bill(Salary salary);



}
