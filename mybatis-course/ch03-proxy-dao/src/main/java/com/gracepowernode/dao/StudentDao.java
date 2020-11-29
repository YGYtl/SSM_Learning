package com.gracepowernode.dao;

import com.gracepowernode.domain.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectStudents();

    public Integer insertStudent(Student student);
}
