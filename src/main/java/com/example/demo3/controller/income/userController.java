package com.example.demo3.controller.income;


import com.example.demo3.entry.User;
import com.example.demo3.service.impl.income.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class userController  {

    @Autowired
    UserServiceImpl userServiceimpl;


    User user;

    @RequestMapping(value = "gotomain")
    public String gotoMain(){return "/main";}

    @RequestMapping(value = "gotoincome_bill")
    public String gotoIncom_Bill(){return "/income_bill";}

    @RequestMapping(value = "gotoexpend_bill")
    public String gotoExpend_Bill(){return "/expend_bill";}

    @RequestMapping(value = "gotouser_massage")
    public String gotoUser_Massage(){return "/user_massage";}

    @RequestMapping(value = "gotohelp")
    public String gotoHelp(){return "/help";}


    @RequestMapping("login")
    public String loginTest(){

        return "/login";
    }

    @RequestMapping(value = "/userlogin", method = {RequestMethod.POST})
    public String userLogin(Map<String,Object> map, @RequestParam String idp,@RequestParam String passwordp, HttpServletRequest request, HttpSession session){


        int id = Integer.parseInt(idp);

        user = userServiceimpl.getUserByID(id);

        if (user==null){

            map.put("msg1","未找到用户");

            return  "/login";

        }else if(user.getUserPassword().equals(passwordp)){


            session.setAttribute("user",user);

            return "/main";

        }else{

            map.put("msg2","密码错误");

            return  "/login";

        }

    }
//
//    @RequestMapping(value = "/alluser")
//    public List<User> getUser(){
//
//
//
//        return null;
//    }
}
