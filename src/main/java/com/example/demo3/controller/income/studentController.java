package com.example.demo3.controller.income;

import com.example.demo3.entry.income.Student;
import com.example.demo3.service.impl.income.Student_bill_serviceimp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class studentController {

     @Autowired

     Student_bill_serviceimp student_bill_serviceimp;



     @RequestMapping(value = "addstudent_bill")
     public String goutoAddStudent_Bill(){return "income/addstudent_bill";}

    @RequestMapping(value = "goutostudnetbill_massage")
    public String GoutoStudentBill_Massage(){return "income/studentbill_massage";}


    /**
      * 获取学生缴费账单列表
      * @param pn
      * @param model
      * @param request
      * @param
      * @return
      */
     @RequestMapping(value = "gotoincome_bill", method = {RequestMethod.POST, RequestMethod.GET})
     public ModelAndView StudentIndex(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, Model model, HttpServletRequest request) {


         PageHelper.startPage(pn, 10);

         //根据搜索结果列出学生
         String search = request.getParameter("search");

         System.out.println(search);
        //如果界面没有传入search的值  则搜索全部



         if (search == null || search.equals("")) {

             List<Student> studentList = student_bill_serviceimp.getAllStudent();

             model.addAttribute("students", studentList);

             PageInfo<Student> pageInfo = new PageInfo<>(studentList, 5);

             return new ModelAndView("income/income_bill.html", "pageInfo", pageInfo);

         } else {

        //界面传入search的值 根据姓名查找
             List<Student> studentList = student_bill_serviceimp.getStudentByStudentName(search);

             model.addAttribute("students", studentList);

             PageInfo<Student> pageInfo = new PageInfo<>(studentList, 5);

             return new ModelAndView("income/income_bill.html", "pageInfo", pageInfo);
         }



     }

    /**
     * 通过payID获取student缴费信息
     * @param payID
     * @param model
     * @return
     */
    @RequestMapping(value = "getStudent_BillBypayID", method = {RequestMethod.POST, RequestMethod.GET})
     public String getStudent_BillBypayID(@RequestParam() Integer payID,Model model){

         Student resultStudent  = student_bill_serviceimp.getStudentBypayiID(payID);

         model.addAttribute("student",resultStudent);

         return "updatestudent_bill";
     }


    /**
     * 添加学生账单
     * @param model
     * @param request
     * @param
     * @return
     */
     @RequestMapping(value = "/addstudent_billaction",method = {RequestMethod.POST, RequestMethod.GET})
     public String AddStudent_BillAction(Model model,HttpServletRequest request){

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

             return "income/addstudent_bill.html";

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

             int result = student_bill_serviceimp.insertStudent(student);

            if (result>0){

                model.addAttribute("msg2","插入成功");

               return "income/addstudent_bill.html";

            }else{

                model.addAttribute("msg2","插入失败");

                return "income/addstudent_bill.html";
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
       private String StudnetBill_Massage(Model model,HttpServletRequest httpServletRequest , HttpSession httpSession){

        String studentpayID = httpServletRequest.getParameter("payID");

        String search = httpServletRequest.getParameter("search");

        int payID = Integer.parseInt(studentpayID);
        Student student = student_bill_serviceimp.getStudentBypayiID(payID);



        model.addAttribute("student",student);

        if (search=="1")
        {
            return  "income/studentbill_massage";
        }else
        {
            return  "income/updatestudent_bill";
        }


       }


    /**
     * 修改学生缴费账单
     * @param model
     * @param httpServletRequest
     * @return
     */
       @RequestMapping(value = "/updateStudent_Bill",method = {RequestMethod.POST,RequestMethod.GET})
       public String UpadteStudent_Bill(Model model,HttpServletRequest httpServletRequest)
       {
           String payID_String = httpServletRequest.getParameter("payID");

           //获取前台数据
           String studentName = httpServletRequest.getParameter("studentName");
           String studentAge_String = httpServletRequest.getParameter("studentAge");
           String studentSex = httpServletRequest.getParameter("studentSex");
           String studentParents = httpServletRequest.getParameter("studentParents");
           String studentPhone_String = httpServletRequest.getParameter("studentPhone");
           String payDate = httpServletRequest.getParameter("payDate");
           String payMoney_String = httpServletRequest.getParameter("payMoney");
           String payMan = httpServletRequest.getParameter("payMan");
           String payRemark = httpServletRequest.getParameter("payRemark");


           //空值判断
           if (payID_String.equals("")||studentAge_String.equals("")||studentPhone_String.equals("")||payMoney_String.equals("")||studentName.equals("")||studentSex.equals("")||studentParents.equals("")||payDate.equals("")||payMan.equals("")||payRemark.equals("")) {

               model.addAttribute("msg1","请输入所有信息");

               Student student = new Student();

               student.setStudentSex(studentSex);
               student.setStudentParents(studentParents);
               student.setStudentPhone(Integer.parseInt(studentPhone_String));
               student.setPayRemark(payRemark);
               student.setPayMoney(Integer.parseInt(payMoney_String));
               student.setPayDate(payDate);
               student.setPayMan(payMan);
               student.setPayID(Integer.parseInt(payID_String));
               student.setStudentName(studentName);
               student.setStudentAge(Integer.parseInt(studentAge_String));
               model.addAttribute("student",student);

               return "income/updatestudent_bill.html";

           }else {

               int studentAge = Integer.parseInt(studentAge_String);
               int studentPhone = Integer.parseInt(studentPhone_String);
               int payMoney = Integer.parseInt(payMoney_String);
               int payId = Integer.parseInt(payID_String);

               Student student = new Student();

               student.setStudentSex(studentSex);
               student.setStudentParents(studentParents);
               student.setStudentPhone(studentPhone);
               student.setPayRemark(payRemark);
               student.setPayMoney(payMoney);
               student.setPayDate(payDate);
               student.setPayMan(payMan);
               student.setPayID(payId);
               student.setStudentName(studentName);
               student.setStudentAge(studentAge);

               int result = student_bill_serviceimp.updateStudent(student);

               //修改结果判断
               if (result<=0)
               {
                   model.addAttribute("msg2","修改失败");

                   return "income/updatestudent_bill.html";
               }else {

                   model.addAttribute("msg3","修改成功");
                   model.addAttribute("student",student);

                  return "income/updatestudent_bill.html";

               }
           }

       }


       @RequestMapping(value = "delectstudent_billbypayid")
       public String DelectStudent_billByPayID(Model model ,@RequestParam(value = "payId") Integer payId)
       {
           int result = student_bill_serviceimp.deleteStudent(payId);

           if (result>0)
           {
               return "income_bill";
           }else
           {
               Student student = student_bill_serviceimp.getStudentBypayiID(payId);

               model.addAttribute("student",student);

               return "studentbill_massage";
           }
       }
}
