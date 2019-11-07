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
        registry.addViewController("/income_bill.html").setViewName("income_bill");
        registry.addViewController("/addstudent_bill.html").setViewName("addstudent_bill");
        registry.addViewController("/addstudent_billaction.html").setViewName("addstudent_billaction");
        registry.addViewController("/studentbill_massage.html").setViewName("studentbill_massage");
        registry.addViewController("/expend_bill.html").setViewName("expend_bill");
        registry.addViewController("/user_massage.html").setViewName("user_massage");
        registry.addViewController("/help.html").setViewName("help");

        registry.addViewController("/addsponsor_bill.html").setViewName("addsponsor_bill");
        registry.addViewController("/sponsorbill_massage.html").setViewName("sponsorbill_massage");

        registry.addViewController("/sponsorincome_bill.html").setViewName("sponsorincome_bill");

    }
}
