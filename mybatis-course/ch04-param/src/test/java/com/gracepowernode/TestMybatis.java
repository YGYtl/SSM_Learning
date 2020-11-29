package com.gracepowernode;

import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.domain.Student;
import com.gracepowernode.ov.QueryParam;
import com.gracepowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.junit.Test;

import java.awt.*;
import java.util.List;

public class TestMybatis {
    @Test
    public void testselectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println(student);
    }

    @Test
    public void testselectMulitParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam paramqp = new QueryParam("李四",88);
        List<Student> studentList = dao.selectMultiObject(paramqp);
        for(Student student: studentList){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$Order(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.SelectUse$Order("name");
        for(Student student: students){
            System.out.println(student);
        }
        sqlSession.close();
    }

}
