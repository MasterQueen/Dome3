package com.example.demo3.mapper;

 import  com.example.demo3.entry.Sponsor;
import com.example.demo3.entry.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SponsorMapper {

    /**
     * 根据ID获取
     * @param
     * @return
     */
    Sponsor getSponsorBypayID(int sponsor_payID);

    /**
     * 根据获取名字获取
     * @param
     * @return
     */
    List<Sponsor> getSponsorByName(String  sponsorName);

    /**
     * 获取全部
     * @return
     */
    List<Sponsor> getAllSponsor();

    /**
     * 插入Student
     * @param
     * @return
     */
    boolean insterSponsor(Sponsor sponsor);



}
