package com.example.demo3.controller.expend;


import com.example.demo3.entry.expend.Bonus;
import com.example.demo3.entry.expend.Salary;
import com.example.demo3.service.expend.Salary_bill_service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class salaryController {

    @Autowired
    private Salary_bill_service salary_bill_service;


    @RequestMapping(value = "gotosalary_bill")
    public ModelAndView SalaryIndex(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Model model, HttpServletRequest request) {

        PageHelper.startPage(pn, 10);

        //获取前端接收的查询条件
        String search = request.getParameter("search");


        //如果界面没有传入search的值  则搜索全部


        if (search == null || search.equals("")) {

            List<Salary> SalaryList = salary_bill_service.getAllSalary_Bill();
            model.addAttribute("salarys", SalaryList);

            PageInfo<Salary> pageInfo = new PageInfo<>(SalaryList, 5);

            return new ModelAndView("expend/salary_bill.html", "pageInfo", pageInfo);

        } else {

            //前端获取到查询条件，根据查询条件进行查询
            Salary salary = new Salary();


            String  type = request.getParameter("select");

            if (type.equals("bonus_expendDate"))
            {
                salary.setSalary_expendDate(search);
            }else if (type.equals("bonus_expendAim"))

            {
                salary.setSalary_expendAim(search);
            }else if (type.equals("bonus_transactor"))
            {
               salary.setSalary_transactor(search);
            }

            List<Salary> salaryList = salary_bill_service.getSalary_Bill(salary);
            model.addAttribute("salarys", salaryList);

            PageInfo<Salary> pageInfo = new PageInfo<>(salaryList, 5);

            return new ModelAndView("expend/salary_bill.html", "pageInfo", pageInfo);
        }



    }


}



