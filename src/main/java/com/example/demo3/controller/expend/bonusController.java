package com.example.demo3.controller.expend;


import com.example.demo3.entry.expend.Bonus;
import com.example.demo3.service.expend.Bonus_bill_service;
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
public class bonusController {

    @Autowired
    Bonus_bill_service bonus_bill_service;

    @RequestMapping(value = "addbonus_bill")
    public String  gotoAddbonus_bill(){return "expend/addbonus_bill.html";}


    /**
     * 2019/12/4
     * LIBIN
     * 红利支出列表显示
     * @param pn
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "gotobonus_bill", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView BonusIndex(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Model model, HttpServletRequest request) {
        PageHelper.startPage(pn, 10);
        //获取前端接收的查询条件
        String search = request.getParameter("search");
        //如果界面没有传入search的值  则搜索全部
        if (search == null || search.equals("")) {
            List<Bonus> bonusList = bonus_bill_service.getAllBonus();
            model.addAttribute("bonuss", bonusList);
            PageInfo<Bonus> pageInfo = new PageInfo<>(bonusList, 5);
            return new ModelAndView("expend/bonus_bill.html", "pageInfo", pageInfo);
        } else {
            //前端获取到查询条件，根据查询条件进行查询
            Bonus bonus = new Bonus();
            String  type = request.getParameter("select");
            if (type.equals("bonus_expendDate"))
            {
                bonus.setBonus_expendDate(search);
            }else if (type.equals("bonus_expendAim"))

            {
                bonus.setBonus_expendAim(search);
            }else if (type.equals("bonus_transactor"))
            {
                bonus.setBonus_transactor(search);
            }
            List<Bonus> bonusList = bonus_bill_service.getBonus(bonus);
            model.addAttribute("bonuss", bonusList);
            PageInfo<Bonus> pageInfo = new PageInfo<>(bonusList, 5);
            return new ModelAndView("expend/bonus_bill.html", "pageInfo", pageInfo);
        }
    }
    /**
     * 2019/12/4
     * LIBIN
     * 添加红利账单记录
     * @param model
     * @param httpServletRequest
     * @return
     */
      @RequestMapping(value = "addbonus_billAction",method = {RequestMethod.POST,RequestMethod.GET})
      public String AddBonus_bill(Model model ,HttpServletRequest httpServletRequest)
      {
          String  bonus_expendMoney_String = httpServletRequest.getParameter("bonus_expendMoney");
          String  bonus_expendDate = httpServletRequest.getParameter("bonus_expendDate");
          String  bonus_expendAim = httpServletRequest.getParameter("bonus_expendAim");
          String  bonus_expendRemark = httpServletRequest.getParameter("bonus_expendRemark");
          String  bonus_transactor = httpServletRequest.getParameter("bonus_transactor");
          if (bonus_expendAim.equals("")||bonus_expendDate.equals("")||bonus_expendMoney_String.equals("")||bonus_expendRemark.equals("")||bonus_transactor.equals(""))
          {
              model.addAttribute("msg1","请输入所有信息");
              return "expend/addbonus_bill.html";
          }
          if (bonus_expendRemark.length()>20)
          {
              model.addAttribute("msg2","备注信息不能超过20字");
              return "expend/addbonus_bill.html";
          }
          Bonus bonus = new Bonus();
          bonus.setBonus_expendAim(bonus_expendAim);
          bonus.setBonus_expendDate(bonus_expendDate);
          bonus.setBonus_expendMoney(Integer.valueOf(bonus_expendMoney_String));
          bonus.setBonus_expendRemark(bonus_expendRemark);
          bonus.setBonus_transactor(bonus_transactor);
          int result = bonus_bill_service.insertBonus(bonus);
          if (result>0)
          {
              model.addAttribute("msg3","添加成功");
              return "expend/addbonus_bill.html";
          }else {
              model.addAttribute("msg4","添加失败");
              return "expend/addbonus_bill.html";
          }
      }

    /**
     * 2019/12/4
     * 详细信息，修改信息获取资源
     * @param model
     * @param httpServletRequest
     * @return
     */
      @RequestMapping(value = "bonusbill_massage",method =RequestMethod.GET)
      public String bonus_BillMassage( Model model ,HttpServletRequest httpServletRequest)
      {

          String search = httpServletRequest.getParameter("search");

          String bonus_expendID = httpServletRequest.getParameter("bonus_expendID");

          Bonus bonus = bonus_bill_service.getBonusById(Integer.valueOf(bonus_expendID));

          model.addAttribute("bonus",bonus);

          if(search.equals("1"))
          {

              return "expend/bonusbill_massage";
          }else {

              return "expend/updatebonus_bill";
          }

      }
      @RequestMapping(value = "updatebonus_massage" ,method =RequestMethod.GET)
      public String updateBonus_bill(Model model ,HttpServletRequest httpServletRequest)
      {
          String  bonus_expendMoney_String = httpServletRequest.getParameter("bonus_expendMoney");
          String  bonus_expendDate = httpServletRequest.getParameter("bonus_expendDate");
          String  bonus_expendAim = httpServletRequest.getParameter("bonus_expendAim");
          String  bonus_expendRemark = httpServletRequest.getParameter("bonus_expendRemark");
          String  bonus_transactor = httpServletRequest.getParameter("bonus_transactor");
          String  bonus_expendID = httpServletRequest.getParameter("bonus_expendID");
          if (bonus_expendAim.equals("")||bonus_expendDate.equals("")||bonus_expendMoney_String.equals("")||bonus_expendRemark.equals("")||bonus_transactor.equals(""))
          {
              model.addAttribute("msg1","请输入所有信息");

              return "expend/updatebonus_bill.html";
          }
          Bonus bonus =  new Bonus();
          bonus.setBonus_expendID(Integer.valueOf(bonus_expendID));
          bonus.setBonus_transactor(bonus_transactor);
          bonus.setBonus_expendAim(bonus_expendAim);
          bonus.setBonus_expendDate(bonus_expendDate);
          bonus.setBonus_expendRemark(bonus_expendRemark);
          bonus.setBonus_expendMoney(Integer.valueOf(bonus_expendMoney_String));
          int result  = bonus_bill_service.updateBonus(bonus);

          if (result>0)
          {

              model.addAttribute("msg1","修改成功");
              model.addAttribute("bonus",bonus);
              return "expend/updatebonus_bill";
          }else
          {
              model.addAttribute("msg2","修改失败");
              return "expend/updatebonus_bill";
          }



      }

}
