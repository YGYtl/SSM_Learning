package com.gracepowernode;

import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.domain.Student;
import com.gracepowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.awt.*;
import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        /*
        * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
        * getMapper能获取dao接口对应的实现类对象
        * */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao="+dao.getClass().getName());
        //com.sun.proxy.$Proxy2: jdk的动态代理

        List<Student> studentList = dao.selectStudents();
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1008,"小花","xiaohua@qq.com",10);
        Integer nums = dao.insertStudent(student);
        //手动提交事务
        sqlSession.commit();
        System.out.println("插入成功!!");
        //关闭
        sqlSession.close();
    }
}
