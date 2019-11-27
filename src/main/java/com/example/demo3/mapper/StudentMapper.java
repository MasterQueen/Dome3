package com.example.demo3.mapper;

import com.example.demo3.entry.income.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {

    /**
     * 根据ID获取
     * @param payID
     * @return
     */
    Student getStudentByID(int payID);

    /**
     * 根据获取名字获取
     * @param studentName
     * @return
     */
    List<Student> getStudentByName(String  studentName);

    /**
     * 获取全部
     * @return
     */
    List<Student> getAllStudent();

    /**
     * 插入Student
     * @param student
     * @return
     */
    int insterStudent(Student student);


    /**
     * 更新student信息
     * @param student
     * @return
     */
    int updateStudentMassage(Student student);


    /**
     * 根据payID删除student信息
     * @param payID
     * @return
     */
    int delectStudentMassage(int payID);




}
