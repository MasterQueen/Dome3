package com.example.demo3.service.impl.expend;


import com.example.demo3.entry.expend.Salary;
import com.example.demo3.mapper.SalaryMapper;
import com.example.demo3.service.expend.Salary_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Salary_bill_serviceimp implements Salary_bill_service {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public List<Salary> getSalary_Bill(Salary salary) {
        return salaryMapper.getSalary_Bill(salary);
    }

    @Override
    public List<Salary> getAllSalary_Bill() {
        return salaryMapper.getAllSalary_Bill();
    }

    @Override
    public Salary getSalary_BillByID(int salary_expendID) {
        return  salaryMapper.getSalary_BillByID(salary_expendID);
    }

    @Override
    public int updateSalary_BillByID(Salary salary) {
        return salaryMapper.updateSalary_BillByID(salary);
    }

    @Override
    public int insertSalary_Bill(Salary salary) {
        return salaryMapper.insertSalary_Bill(salary);
    }

}
