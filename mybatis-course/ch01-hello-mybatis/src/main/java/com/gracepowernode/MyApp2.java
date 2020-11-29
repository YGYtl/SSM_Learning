package com.gracepowernode;

import com.gracepowernode.domain.Student;
import com.gracepowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //【重要】指定要执行的sql语句的表示。 sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.gracepowernode.dao.StudentDao.selectStudents";
        //【重要】执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //输出结果
        for(Student stu : studentList){
            System.out.println("查询的学生："+stu);
        }
        //关闭SqlSession对象
        sqlSession.close();
    }
}
