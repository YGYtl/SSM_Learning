package com.gracepowernode.dao;

import com.gracepowernode.domain.Student;
import com.gracepowernode.ov.QueryParam;
import com.gracepowernode.ov.myStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public Student selectStudentById(Integer id);
    public List<Student> selectMulitParam(@Param("myname") String name, @Param("myage") Integer age);
    int CountStudent();

    /*
    * 使用resultMap定义映射关系
    * */
    List<Student> selectAllStudents();

    List<myStudent> selectAllStudents2();

    List<myStudent> selectDiffColProperty();


    /*第一种模糊查询，在java代码指定 like的内容*/
    List<Student> selectLikeOne(@Param("myname") String name);

    /*name就是飞值，在mapper中拼接 like "%" 飞 "%"*/
    List<Student> selectLikeTwo(@Param("myname") String name);
}
