package com.example.demo3.service.impl.income;

import com.example.demo3.entry.income.Student;
import com.example.demo3.mapper.StudentMapper;
import com.example.demo3.service.Student_bill_service;
import org.springframework.beans.factory.annotation.Autowired;
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
    public int insertStudent(Student student) { return studentMapper.insterStudent(student);}

    @Override
    public int deleteStudent(int payID) {

        return studentMapper.delectStudentMassage(payID);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudentMassage(student);
    }
}
