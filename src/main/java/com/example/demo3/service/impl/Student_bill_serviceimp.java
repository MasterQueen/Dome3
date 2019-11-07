package com.example.demo3.service.impl;

import com.example.demo3.entry.Student;
import com.example.demo3.mapper.StudentMapper;
import com.example.demo3.service.Student_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_bill_serviceimp implements Student_bill_service {


    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudentByStudentName(String studentName) { return studentMapper.getStudentByName(studentName); }

  //  @Cacheable(value = "mycaahe")
    @Override
    public List<Student> getAllStudent() {
        return studentMapper.getAllStudent();
    }

   // @Cacheable(value = "mycaahe")
    @Override
    public Student getStudentBypayiID(int payID) {
        return studentMapper.getStudentByID(payID);
    }

   // @CachePut(value = "mycahe")
    @Override
    public boolean insertStudent(Student student) { return studentMapper.insterStudent(student);}

    @Override
    public boolean deleteStudent(int payID) {
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }
}
