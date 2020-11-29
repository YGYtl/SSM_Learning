package com.gracepowernode;

import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.domain.Student;
import com.gracepowernode.ov.QueryParam;
import com.gracepowernode.ov.myStudent;
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
        sqlSession.close();
    }

    @Test
    public void TestCountStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int counts = dao.CountStudent();
        System.out.println("学生的数量="+counts);
        sqlSession.close();
    }

    @Test
    public void TestCountStudent2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<myStudent> students = dao.selectAllStudents2();
        for (myStudent stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void TestselectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<myStudent> students = dao.selectDiffColProperty();
        for (myStudent stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void TestselectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "%飞%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void TestselectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "飞";
        List<Student> students = dao.selectLikeTwo(name);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }
}
