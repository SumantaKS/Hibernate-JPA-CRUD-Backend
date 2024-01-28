package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    //C of CRUD
    void save(Student theStudent);

    //R of CRUD
    Student findById(Integer id);
    //For reading multiple results
    List<Student> findAll();

    //U of CRUD

    //D of CRUD
}
