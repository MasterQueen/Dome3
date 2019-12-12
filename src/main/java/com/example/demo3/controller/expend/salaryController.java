package com.example.demo3.controller.expend;



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


    @RequestMapping(value = "addsalary_bill")
    public String  gotoAddsalay_bill(){return "expend/addsalary_bill.html";}


    /**
     * 获取工资支出列表信息
     * @param pn
     * @param model
     * @param request
     * @return
     */
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

            if (type.equals("salary_expendDate"))
            {
                salary.setSalary_expendDate(search);
            }else if (type.equals("salary_expendAim"))

            {
                salary.setSalary_expendAim(search);
            }else if (type.equals("salary_transactor"))
            {
               salary.setSalary_transactor(search);
            }

            List<Salary> salaryList = salary_bill_service.getSalary_Bill(salary);

            if (salaryList.size()==0)
            {
                PageInfo<Salary> pageInfo = new PageInfo<>(salaryList, 5);

                model.addAttribute("msg1", "未找到记录");

                return new ModelAndView("expend/salary_bill.html", "pageInfo", pageInfo);
            }
            model.addAttribute("salarys", salaryList);

            PageInfo<Salary> pageInfo = new PageInfo<>(salaryList, 5);

            return new ModelAndView("expend/salary_bill.html", "pageInfo", pageInfo);
        }

    }


    /**
     * 工资支出详情展示
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "salarybill_massage",method =RequestMethod.GET)
    public String salary_BillMassage( Model model ,HttpServletRequest httpServletRequest)
    {

        String search = httpServletRequest.getParameter("search");

        String salary_expendID = httpServletRequest.getParameter("salary_expendID");

        Salary salary = salary_bill_service.getSalary_BillByID(Integer.valueOf(salary_expendID));

        model.addAttribute("salary",salary);

        if(search.equals("1"))
        {

            return "expend/salarybill_massage";
        }else {

            return "expend/updatesalary_bill";
        }

    }

    /**
     * 更新账单信息
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "updatesalary_massage" ,method =RequestMethod.GET)
    public String updateSalary_bill(Model model ,HttpServletRequest httpServletRequest)
    {

        String  salary_expendMoney_String = httpServletRequest.getParameter("salary_expendMoney");
        String  salary_expendDate = httpServletRequest.getParameter("salary_expendDate");
        String  salary_expendAim = httpServletRequest.getParameter("salary_expendAim");
        String  salary_expendRemark = httpServletRequest.getParameter("salary_expendRemark");
        String  salary_transactor = httpServletRequest.getParameter("salary_transactor");
        String  salary_expendID = httpServletRequest.getParameter("salary_expendID");
        if (salary_expendAim.equals("")||salary_expendDate.equals("")||salary_expendMoney_String.equals("")||salary_expendRemark.equals("")||salary_transactor.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");

            return "expend/updatesalary_bill.html";
        }
        Salary salary =  new  Salary();
        salary.setSalary_expendID(Integer.valueOf(salary_expendID));
        salary.setSalary_transactor(salary_transactor);
        salary.setSalary_expendAim(salary_expendAim);
        salary.setSalary_expendDate(salary_expendDate);
        salary.setSalary_expendRemark(salary_expendRemark);
        salary.setSalary_expendMoney(Integer.valueOf(salary_expendMoney_String));
        int result  = salary_bill_service.updateSalary_BillByID(salary);

        if (result>0)
        {

            model.addAttribute("msg1","修改成功");
            model.addAttribute("salary",salary);
            return "expend/updatesalary_bill";
        }else
        {
            model.addAttribute("msg2","修改失败");
            return "expend/updatesalary_bill";
        }


    }


    /**
     * 添加工资支出信息
     * @param model
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "addsalary_billAction",method = {RequestMethod.POST,RequestMethod.GET})
    public String AddSalary_bill(Model model ,HttpServletRequest httpServletRequest)
    {
        String  salary_expendMoney_String = httpServletRequest.getParameter("salary_expendMoney");
        String  salary_expendDate = httpServletRequest.getParameter("salary_expendDate");
        String  salary_expendAim = httpServletRequest.getParameter("salary_expendAim");
        String  salary_expendRemark = httpServletRequest.getParameter("salary_expendRemark");
        String  salary_transactor = httpServletRequest.getParameter("salary_transactor");

        if (salary_expendAim.equals("")||salary_expendDate.equals("")||salary_expendMoney_String.equals("")||salary_expendRemark.equals("")||salary_transactor.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");

            return "expend/addsalary_bill.html";
        }

        if (salary_expendRemark.length()>20)
        {
            model.addAttribute("msg2","备注信息不能超过20字");

            return "expend/addsalary_bill.html";
        }

        Salary salary = new Salary();
        salary.setSalary_transactor(salary_transactor);
        salary.setSalary_expendAim(salary_expendAim);
        salary.setSalary_expendDate(salary_expendDate);
        salary.setSalary_expendRemark(salary_expendRemark);
        salary.setSalary_expendMoney(Integer.valueOf(salary_expendMoney_String));

        int result = salary_bill_service.insertSalary_Bill(salary);

        if (result>0)
        {
            model.addAttribute("msg3","添加成功");

            return "expend/addsalary_bill.html";
        }else {

            model.addAttribute("msg4","添加失败");
            return "expend/addsalary_bill.html";
        }


    }


}



