package com.example.demo3.controller;

import com.example.demo3.entry.Student;
import com.example.demo3.entry.User;
import com.example.demo3.service.impl.Student_bill_serviceimp;
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
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@Controller

public class studentController {

     @Autowired

     Student_bill_serviceimp student_bill_serviceimp;



     @RequestMapping(value = "addstudent_bill")
     public String goutoAddStudent_Bill(){return "/addstudent_bill";}

    @RequestMapping(value = "goutostudnetbill_massage")
    public String GoutoStudentBill_Massage(){return "/studentbill_massage";}


    /**
      * 获取学生缴费账单列表
      * @param pn
      * @param model
      * @param request
      * @param session
      * @return
      */
     @RequestMapping(value = "gotoincome_bill", method = {RequestMethod.POST, RequestMethod.GET})
     public ModelAndView StudentIndex(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Model model, HttpServletRequest request, HttpSession session) {


         PageHelper.startPage(pn, 10);

         //根据搜索结果列出学生
         String search = request.getParameter("search");
         System.out.println(search);
        //如果界面没有传入search的值  则搜索全部
         if (search == null || search.equals("")) {

             List<Student> studentList = student_bill_serviceimp.getAllStudent();

             model.addAttribute("students", studentList);

             PageInfo<Student> pageInfo = new PageInfo<>(studentList, 5);

             return new ModelAndView("/income_bill.html", "pageInfo", pageInfo);

         } else {

        //界面传入search的值 根据姓名查找
             List<Student> studentList = student_bill_serviceimp.getStudentByStudentName(search);

             model.addAttribute("students", studentList);

             PageInfo<Student> pageInfo = new PageInfo<>(studentList, 5);

             return new ModelAndView("/income_bill.html", "pageInfo", pageInfo);
         }

     }


    /**
     * 添加学生账单
     * @param model
     * @param request
     * @param httpSession
     * @return
     */
     @RequestMapping(value = "/addstudent_billaction",method = {RequestMethod.POST, RequestMethod.GET})
     public String AddStudent_BillAction(Model model,HttpServletRequest request, HttpSession httpSession){

         String studentName = request.getParameter("studentName");
         String studentSex = request.getParameter("studentSex");
         String studentAge_String = request.getParameter("studentAge");
         String studentParents = request.getParameter("studentParents");
         String studentPhone_String= request.getParameter("studentPhone");
         String payDate = request.getParameter("payDate");
         String payMoney_String = request.getParameter("payMoney");
         String payMan = request.getParameter("payMan");
         String payRemark = request.getParameter("payRemark");


         if (studentAge_String.equals("")||studentPhone_String.equals("")||payMoney_String.equals("")||studentName.equals("")||studentSex.equals("")||studentParents.equals("")||payDate.equals("")||payMan.equals("")||payRemark.equals("")){


             System.out.println("kongde");
             model.addAttribute("msg1","请输入所有信息");

             return "/addstudent_bill.html";

         }else{



             int studentAge = Integer.parseInt(studentAge_String);
             int studentPhone = Integer.parseInt(studentPhone_String);
             int payMoney = Integer.parseInt(payMoney_String);

             Student student = new Student();

             student.setStudentName(studentName);
             student.setPayDate(payDate);
             student.setPayMan(payMan);
             student.setPayMoney(payMoney);
             student.setPayRemark(payRemark);
             student.setStudentPhone(studentPhone);
             student.setStudentParents(studentParents);
             student.setStudentAge(studentAge);
             student.setStudentSex(studentSex);

             boolean result = student_bill_serviceimp.insertStudent(student);

            if (result){


               return "forward:/addstudent_bill";

            }else{

                model.addAttribute("msg2","插入失败");

                return "/addstudent_bill";
            }


         }


     }

    /**
     * 查看学生缴费详细信息
     * @param model
     * @param httpServletRequest
     * @param httpSession
     * @return
     */
     @RequestMapping(value = "/studentbill_massage",method = {RequestMethod.POST, RequestMethod.GET})
       public String StudnetBill_Massage(Model model,HttpServletRequest httpServletRequest , HttpSession httpSession){

        String studentpayID = httpServletRequest.getParameter("studentpayID");

        int payID = Integer.parseInt(studentpayID);
        Student student = student_bill_serviceimp.getStudentBypayiID(payID);

        System.out.println(student);

        model.addAttribute("student",student);


         return  "/studentbill_massage";
       }
     


}
