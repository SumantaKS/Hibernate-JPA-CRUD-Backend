package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

public interface StudentDAO {

    //C of CRUD
    void save(Student theStudent);

    //R of CRUD
    Student findById(Integer id);

    //U of CRUD

    //D of CRUD
}
