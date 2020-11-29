package com.gracepowernode.dao;

import com.gracepowernode.domain.Student;
import com.gracepowernode.ov.QueryParam;

import java.util.List;

public interface StudentDao {
    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(QueryParam qpstu);

    //where使用
    List<Student> selectStudentWhere(QueryParam qpstu);

    //foreach 用法1
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach 用法2
    List<Student> selectForeachTwo(List<Student> stulist);

    //PageHelper查询
    List<Student> selectAllStudent();
}
