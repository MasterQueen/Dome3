package com.example.demo3.controller.expend;

import com.alibaba.druid.util.StringUtils;
import com.example.demo3.entry.expend.Bonus;
import com.example.demo3.entry.expend.Expend_Other;
import com.example.demo3.entry.expend.Salary;
import com.example.demo3.service.expend.Expend_Other_bill_service;
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
public class Expend_other_Controller {
    @Autowired
    private Expend_Other_bill_service expend_other_bill_service;
    @RequestMapping(value = "addother_expend_bill")
    public String gotoAddOther_expend_bill(){
        return "expend/addother_expend.html";
    }
    @RequestMapping(value = "gotoother_expend_bill")
    public ModelAndView Expend_OtherIndex(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Model model, HttpServletRequest request) {
        PageHelper.startPage(pn, 10);
        //获取前端接收的查询条件
        String search = request.getParameter("search");
        //如果界面没有传入search的值  则搜索全部
        if (search == null || search.equals("")) {
            List<Expend_Other> other_expendList = expend_other_bill_service.getAllExpend_Other_Bill();
            model.addAttribute("other_expends", other_expendList);
            PageInfo<Expend_Other> pageInfo = new PageInfo<>(other_expendList, 5);
            return new ModelAndView("expend/other_expend_bill.html", "pageInfo", pageInfo);
        } else {
            //前端获取到查询条件，根据查询条件进行查询
            Expend_Other expend_other = new Expend_Other();
            String  type = request.getParameter("select");
            if (type.equals("Date"))
            {
                expend_other.setOther_expendDate(search);
            }else if (type.equals("Man"))
            {
                expend_other.setOther_expendMan(search);
            }else if (type.equals("Transactor"))
            {
                expend_other.setExpend_transactor(search);
            }else if (type.equals("Keyword"))
            {
                expend_other.setOther_keyword(search);
            }
            List<Expend_Other> other_expendList = expend_other_bill_service.getExpend_Other_Bill(expend_other);
            if (other_expendList.size()==0)
            {
                PageInfo<Expend_Other> pageInfo = new PageInfo<>(other_expendList, 5);
                model.addAttribute("msg1", "未找到记录");
                return new ModelAndView("expend/other_expend_bill.html", "pageInfo", pageInfo);
            }
            model.addAttribute("other_expends", other_expendList);
            PageInfo<Expend_Other> pageInfo = new PageInfo<>(other_expendList, 5);
            return new ModelAndView("expend/other_expend_bill.html", "pageInfo", pageInfo);
        }
    }


    @RequestMapping(value = "addother_expend_billAction",method = {RequestMethod.POST,RequestMethod.GET})
    public  String other_expend_bill_massage (Model model ,HttpServletRequest httpServletRequest)
    {
        Expend_Other expend_other = new Expend_Other();
        String other_expendMoneyString  = httpServletRequest.getParameter("other_expendMoney");
        String other_expendMan = httpServletRequest.getParameter("other_expendMan");
        String other_expendDate = httpServletRequest.getParameter("other_expendDate");
        String expend_transactor = httpServletRequest.getParameter("expend_transactor");
        String other_expendRemark = httpServletRequest.getParameter("other_expendRemark");
        String other_keyword = httpServletRequest.getParameter("other_keyword");
        if (other_expendDate.equals("")||other_expendMan.equals("")||other_expendMoneyString.equals("")||other_keyword.equals("")||expend_transactor.equals("")||other_expendRemark.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");
            return  "expend/addother_expend.html";
        }
        expend_other.setOther_keyword(other_keyword);
        expend_other.setExpend_transactor(expend_transactor);
        expend_other.setOther_expendDate(other_expendDate);
        expend_other.setOther_expendMan(other_expendMan);
        expend_other.setOther_expendMoney(Integer.valueOf(other_expendMoneyString));
        expend_other.setOther_expendRemark(other_expendRemark);
        int result = expend_other_bill_service.insertExpend_Other_Bill(expend_other);
        if (result >0)
        {
            model.addAttribute("msg1","添加成功");
            return  "expend/addother_expend.html";
        }else {
            model.addAttribute("msg1","添加失败");
            return  "expend/addother_expend.html";
        }
    }

    @RequestMapping(value = "other_expend_bill_massage",method = {RequestMethod.POST,RequestMethod.GET})
    public String other_expend_BillMassage( Model model ,HttpServletRequest httpServletRequest)
    {
        String search = httpServletRequest.getParameter("search");
        String other_expendID = httpServletRequest.getParameter("other_expendID");
        Expend_Other expend_other = expend_other_bill_service.getExpend_Other_BillByID(Integer.valueOf(other_expendID)) ;
        model.addAttribute("other_expend",expend_other);
        if(search.equals("1"))
        {
            return "expend/other_expendbill_massage";
        }else {
            return "expend/update_other_expend_bill";
        }
    }


    @RequestMapping(value = "update_other_expend_bill",method = {RequestMethod.POST,RequestMethod.GET} )
    public String update_other_expend_bill(Model model,HttpServletRequest httpServletRequest)
    {
        Expend_Other expend_other = new Expend_Other();
        String other_expendMoneyString  = httpServletRequest.getParameter("other_expendMoney");
        String other_expendMan = httpServletRequest.getParameter("other_expendMan");
        String other_expendDate = httpServletRequest.getParameter("other_expendDate");
        String expend_transactor = httpServletRequest.getParameter("expend_transactor");
        String other_expendRemark = httpServletRequest.getParameter("other_expendRemark");
        String other_keyword = httpServletRequest.getParameter("other_keyword");
        String other_expendID = httpServletRequest.getParameter("other_expendID");
        if (other_expendDate.equals("")||other_expendMan.equals("")||other_expendMoneyString.equals("")||other_keyword.equals("")||expend_transactor.equals("")||other_expendRemark.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");
            return  "expend/update_other_expend_bill.html";
        }
        expend_other.setOther_keyword(other_keyword);
        expend_other.setExpend_transactor(expend_transactor);
        expend_other.setOther_expendDate(other_expendDate);
        expend_other.setOther_expendMan(other_expendMan);
        expend_other.setOther_expendMoney(Integer.valueOf(other_expendMoneyString));
        expend_other.setOther_expendRemark(other_expendRemark);
        expend_other.setOther_expendID(Integer.valueOf(other_expendID));
       int result= expend_other_bill_service.updateExpend_Other_BillByID(expend_other);
        if (result>0)
        {
            model.addAttribute("other_expend",expend_other);
            model.addAttribute("msg1","修改成功");
            return "expend/update_other_expend_bill.html";
        }else {
            model.addAttribute("msg1","修改成功");
            return "expend/update_other_expend_bill.html";
        }
    }
}
