package com.example.demo3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class
WebMvcConfig implements WebMvcConfigurer {

    /*
    拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //设置拦截，释放静态文件

       registry.addInterceptor(new LoginHandlerInterceptero()).addPathPatterns("/**")
               .excludePathPatterns("/userlogin","/login.html"

                      , "/assets/css/**","/assets/js/**", "/assets/img/**","/assets/ico/**","/assets/font/**",
                       "/assetslogin/bootstrap/css/**","/assetslogin/bootstrap/fonts/**","/assetslogin/bootstrap/js/**",
                       "/assetslogin/css/**","/assetslogin/ico/**","/assetslogin/img/**","/assetslogin/js/**",
                       "/assetslogin/font-awesome/**",
                       "resources/banner"
               );

    }

    /*
    静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

    }

    /*
    视图控制
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("income/income_bill.html").setViewName("income_bill");
        registry.addViewController("income/addstudent_bill.html").setViewName("addstudent_bill");
        registry.addViewController("income/addstudent_billaction.html").setViewName("addstudent_billaction");
        registry.addViewController("income/studentbill_massage.html").setViewName("studentbill_massage");
        registry.addViewController("income/updatestudent_bill.html").setViewName("updatestudent_bill");


        registry.addViewController("/expend_bill.html").setViewName("expend_bill");
        registry.addViewController("/user_massage.html").setViewName("user_massage");
        registry.addViewController("/help.html").setViewName("help");


        //赞助收入
        registry.addViewController("income/addsponsor_bill.html").setViewName("addsponsor_bill");
        registry.addViewController("income/sponsorbill_massage.html").setViewName("sponsorbill_massage");
        registry.addViewController("income/updatesponsor_bill.html").setViewName("updatesponsor_bill");
        registry.addViewController("income/sponsorincome_bill.html").setViewName("sponsorincome_bill");

        //其他收入
        registry.addViewController("income/otherincome_bill.html").setViewName("otherincome_bill");
        registry.addViewController("income/addother_income_bill.html").setViewName("addother_income_bill");
        registry.addViewController("income/other_incomebill_massage.html").setViewName("other_incomebill_massage");
        registry.addViewController("income/updateotherincome_bill.html").setViewName("updateotherincome_bill");


        //红利支出
        registry.addViewController("expend/bonus_bill.html").setViewName("bonus_bill");
        registry.addViewController("expend/addbonus_bill.html").setViewName("addbonus_bill");
        registry.addViewController("expend/bonusbill_massage.html").setViewName("bonusbill_massage");
        registry.addViewController("expend/updatebonus_bill.html").setViewName("updatebonus_bill");

        //工资支出
        registry.addViewController("expend/salary_bill.html").setViewName("salary_bill");
        registry.addViewController("expend/addsalary_bill.html").setViewName("addsalary_bill");
        registry.addViewController("expend/salarybill_massage.html").setViewName("salarybill_massage");
        registry.addViewController("expend/updatesalary_bill.html").setViewName("updatesalary_bill");
    }
}
