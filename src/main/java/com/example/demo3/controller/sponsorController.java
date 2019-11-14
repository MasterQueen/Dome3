package com.example.demo3.controller;


import com.example.demo3.entry.Sponsor;
import com.example.demo3.service.impl.Sponsor_bill_sreviceimp;
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
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 赞助商账单类
 */
@Controller
public class sponsorController {

    @Autowired
    Sponsor_bill_sreviceimp sponsor_bill_sreviceimp;


    @RequestMapping(value = "gotosponsorbill_massage")
    public String  gotoSponsporbill_massage(){return "/sponsporbill_massage";}

    @RequestMapping(value = "addsponsor_bill")
    public String  gotoAddSponspor_bill(){return "/addsponsor_bill";}


    @RequestMapping(value = "gotosponsorincome_bill")
    public ModelAndView Sponsporincome_bill(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Model model, HttpServletRequest request)
    {
        PageHelper.startPage(pn,10);

        String search = request.getParameter("search");


        if (search==null||search.equals(""))
        {
            List<Sponsor> sponsorList = sponsor_bill_sreviceimp.getAllSponsor();

            model.addAttribute("sponsorList",sponsorList);

            PageInfo<Sponsor> pageInfo = new PageInfo<>(sponsorList,5);

            return new ModelAndView("/sponsorincome_bill.html", "pageInfo", pageInfo);

        }else {

            List<Sponsor> studentList = sponsor_bill_sreviceimp.getSponsorByName(search);

            model.addAttribute("sponsroList", studentList);

            PageInfo<Sponsor> pageInfo = new PageInfo<>(studentList, 5);

            return new ModelAndView("/sponsorincome_bill.html", "pageInfo", pageInfo);

        }



    }

    @RequestMapping(value = "addsponsor_billaction")

    public String AddSponsorBill_Action(Model model,HttpServletRequest request) {


        String paydate = request.getParameter("sponsor_payDate");
        String payremark = request.getParameter("sponsor_payRemark");
        String sponsorname = request.getParameter("sponsorName");
        String paymoney = request.getParameter("sponsor_payMoney");
        String sponsorphone = request.getParameter("sponsorPhone");

        if (paydate.equals("") || paymoney.equals("") || payremark.equals("") || sponsorname.equals("") || sponsorphone.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");

            return "/addsponsor_bill.html";
        }


            Sponsor sponsor = new Sponsor();


            sponsor.setSponsor_payDate(request.getParameter("sponsor_payDate"));

            sponsor.setSponsor_payRemark(request.getParameter("sponsor_payRemark"));

            sponsor.setSponsorName(request.getParameter("sponsorName"));

            sponsor.setSponsor_payMoney(Integer.parseInt(request.getParameter("sponsor_payMoney")));

            sponsor.setSponsorPhone(Integer.parseInt(request.getParameter("sponsorPhone")));


            boolean result = sponsor_bill_sreviceimp.insterSponsor(sponsor);


        if (result){

            return "forward:/addsponsor_bill";

        }else{

            model.addAttribute("msg2","插入失败");

            return "/addsponsor_bill";
        }

    }



    @RequestMapping(value = "sponsorbill_massage",method = {RequestMethod.POST,RequestMethod.GET})
    private String SponsorBill_Massage(Model model,HttpServletRequest httpServletRequest)
    {
        String sponsor_payID = httpServletRequest.getParameter("sponsor_payID");

        String search = httpServletRequest.getParameter("search");

        int payID = Integer.parseInt(sponsor_payID);

        Sponsor sponsor = sponsor_bill_sreviceimp.getSponsorBypayID(payID);

        model.addAttribute("sponsor",sponsor);

        if (search.equals("1"))
        {
            return "/sponsorbill_massage";
        }else

        {
            return "/updatesponsor_bill";
        }
    }


    @RequestMapping(value = "updatesponsor_bill",method = {RequestMethod.POST,RequestMethod.GET})
    public String UpadteSponsor_Bill(Model model,HttpServletRequest request)
    {


        String payID = request.getParameter("sponsor_payID");
        String paydate = request.getParameter("sponsor_payDate");
        String payremark = request.getParameter("sponsor_payRemark");
        String sponsorname = request.getParameter("sponsorName");
        String paymoney = request.getParameter("sponsor_payMoney");
        String sponsorphone = request.getParameter("sponsorPhone");

        if (paydate.equals("") || paymoney.equals("") || payremark.equals("") || sponsorname.equals("") || sponsorphone.equals(""))
        {
            model.addAttribute("msg1","请输入所有信息");

            return "updatesponsor_bill";

        }else {


            Sponsor sponsor = new Sponsor();

            sponsor.setSponsor_payID(Integer.parseInt(payID));
            sponsor.setSponsor_payDate(paydate);
            sponsor.setSponsor_payRemark(payremark);
            sponsor.setSponsorName(sponsorname);
            sponsor.setSponsorPhone(Integer.parseInt(sponsorphone));
            sponsor.setSponsor_payMoney(Integer.parseInt(paymoney));

            int result = sponsor_bill_sreviceimp.updateSponsorBill(sponsor);

            if (result<=0)
            {
                model.addAttribute("msg2","添加失败");

                return "updatesponsor_bill";
            }else
            {
                model.addAttribute("msg3","修改成功");
                model.addAttribute("sponsor",sponsor);

                return "updatesponsor_bill";
            }

        }


    }

}
