package com.example.demo3.controller.income;


import com.example.demo3.entry.income.Income_Other;
import com.example.demo3.service.Income_Other_bill_service;
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
public class Income_other_Controller {

    @Autowired
    Income_Other_bill_service income_other_bill_service;


    @RequestMapping(value = "addother_income_bill")
    public String  gotoAddOther_income_bill(){return "income/addother_income_bill";}


    @RequestMapping(value ="gotoIncome_Other_Bill")
    public ModelAndView Income_Other_Bill(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,HttpServletRequest request, Model model)
    {
        PageHelper.startPage(pn,10);
        String search = request.getParameter("search");

        if (search==null||search.equals(""))
        {

            List<Income_Other> income_otherList = income_other_bill_service.getAll();

            model.addAttribute("income_other",income_otherList);

            PageInfo<Income_Other> pageInfo = new PageInfo<>(income_otherList,5);

            return new ModelAndView("income/otherincome_bill.html", "pageInfo", pageInfo);
        }else

        {
            List<Income_Other> income_otherList= income_other_bill_service.getIncome_OtherByOther_payMan(search);

            model.addAttribute("income_other",income_otherList);

            PageInfo<Income_Other> pageInfo = new PageInfo<>(income_otherList,5);

            return new ModelAndView("income/otherincome_bill","pageInfo", pageInfo);

        }

    }

    @RequestMapping(value = "addother_income_billaction")
    public String AddOther_Income_bill(Model model,HttpServletRequest httpServletRequest)
    {
        String other_payDate = httpServletRequest.getParameter("other_payDate");

        String other_payMoney = httpServletRequest.getParameter("other_payMoney");

        String other_payMan = httpServletRequest.getParameter("other_payMan");

        String other_payRemark = httpServletRequest.getParameter("other_payRemark");

        if (other_payDate.equals("")|| other_payMan.equals("")||other_payMoney.equals("")||other_payRemark.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");

            return "income/addother_income_bill.html";
        }

        if (other_payRemark.length()>=20)
        {
            model.addAttribute("msg4","备注信息请在20字以内");

            return "income/addother_income_bill.html";
        }

        Income_Other income_other = new Income_Other();

        income_other.setOther_payDate(other_payDate);
        income_other.setOther_payMan(other_payMan);
        income_other.setOther_payRemark(other_payRemark);
        income_other.setOther_payMoney(Integer.parseInt(other_payMoney));

        int result = income_other_bill_service.insertIncome_Other(income_other);

        if (result<=0)
        {
            model.addAttribute("msg2","添加失败");

            return "income/addother_income_bill.html";
        }else
        {
            model.addAttribute("msg2","添加成功");

            return "income/addother_income_bill.html";
        }


    }


    @RequestMapping(value = "other_incomebillmassage",method = {RequestMethod.POST,RequestMethod.GET})
    public String Other_IncomeBillMassage(Model model,HttpServletRequest httpServletRequest)
    {

        String other_payID = httpServletRequest.getParameter("other_payID");

        String search = httpServletRequest.getParameter("search");

        Income_Other income_other = income_other_bill_service.getIncome_OtheByPayId(Integer.parseInt(other_payID));

        model.addAttribute("income_other",income_other);

        if (search.equals("1"))
        {

            return "income/other_incomebill_massage";

        }else

        {

            return "income/updateotherincome_bill";
        }
    }

    @RequestMapping(value = "updateincome_othermassage",method = {RequestMethod.POST,RequestMethod.GET})
    public String Updateincome_otherMassage(Model model,HttpServletRequest httpServletRequest)
    {

        String other_payID = httpServletRequest.getParameter("other_payID");
        String other_payDate = httpServletRequest.getParameter("other_payDate");

        String other_payMoney = httpServletRequest.getParameter("other_payMoney");

        String other_payMan = httpServletRequest.getParameter("other_payMan");

        String other_payRemark = httpServletRequest.getParameter("other_payRemark");

        if (other_payDate.equals("")|| other_payMan.equals("")||other_payMoney.equals("")||other_payRemark.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");

            return "income/updateotherincome_bill.html";
        }

        if (other_payRemark.length()>=20)
        {
            model.addAttribute("msg3","备注信息请在20字以内");

            return "income/updateotherincome_bill.html";
        }

        Income_Other income_other = new Income_Other();

        income_other.setOther_payID(Integer.parseInt(other_payID));
        income_other.setOther_payDate(other_payDate);
        income_other.setOther_payMan(other_payMan);
        income_other.setOther_payRemark(other_payRemark);
        income_other.setOther_payMoney(Integer.parseInt(other_payMoney));

        int result = income_other_bill_service.updateIncome_Other(income_other);

        if (result<=0)
        {
            model.addAttribute("msg2","更新失败");

            return "income/updateotherincome_bill.html";
        }else

        {
            model.addAttribute("msg2","更新成功");

            model.addAttribute("income_other",income_other);

            return "income/updateotherincome_bill.html";
        }
    }
}
