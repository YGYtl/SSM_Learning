package com.gracepowernode;

import com.gracepowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    //测试方法，测试功能
    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径根开始(target/classes)
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        //SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = factory.openSession(true);
        //6.【重要】指定要执行的sql语句的表示。 sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.gracepowernode.dao.StudentDao.insertStudent";
        Student student = new Student(1009,"李白","libai@outlook.com",43);
        //7.执行sql语句，通过sqlId找到语句
        int count = sqlSession.insert(sqlId,student);

        //mybatis默认不是自动提交事物的，所以在insert，update，delete后要手动提交事务
//        sqlSession.commit();

        //8.输出结果
        if(count > 0){
            System.out.println(student+" 插入成功!");
        }
        else{
            System.out.println(student+" 插入失败!");
        }

        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
