package com.gracepowernode.dao.impl;

import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.domain.Student;
import com.gracepowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.gracepowernode.dao.StudentDao.selectStudents";
        //执行sql语句，使用SqlSession类的方法
        List<Student> studentList = sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.gracepowernode.dao.StudentDao.insertStudent";
        int count = sqlSession.insert(sqlId,student);

        sqlSession.commit();

        sqlSession.close();
        return count;
    }
}
