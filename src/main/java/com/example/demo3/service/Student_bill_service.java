package com.example.demo3.service;

import com.example.demo3.entry.Student;

import java.util.List;

public interface Student_bill_service {

    /**
     * 获取所有学生
     * @return
     */
   List<Student> getAllStudent();

    /**
     * 根据ID获取
     * @param payID
     * @return
     */
   Student getStudentBypayiID(int payID);

    /**
     * 根据名字获取
     * @param studentName
     * @return
     */
    List<Student> getStudentByStudentName(String studentName);

    /**
     * 添加学生
     * @param student
     * @return
     */
   boolean insertStudent(Student student);

    /**
     * 删除学生信息
     * @param payID
     * @return
     */
   boolean deleteStudent(int payID);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
   int updateStudent(Student student);




}
