package com.gracepowernode;

import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.dao.impl.StudentDaoImpl;
import com.gracepowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
}
