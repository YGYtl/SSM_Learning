package com.gracepowernode;

import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.dao.impl.StudentDaoImpl;
import com.gracepowernode.domain.Student;
import com.gracepowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis2 {
    @Test
    public void testSelectStudents(){
        //com.gracepowernode.dao.StudentDao
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student(1005,"刘备","liubei@qq.com",88);
        int count = dao.insertStudent(student);
        if(count>0){
            //调用dao对象，获取sql语句的值
            System.out.println("数据插入成功!");
            List<Student> studentList = dao.selectStudents();

            //直接调用sqlSession获取sql语句的值，动态的代理
            SqlSession sqlSession = MyBatisUtils.getSqlSession();
            String sql = "com.gracepowernode.dao.StudentDao.selectStudents";
            List<Student> studentList2 = sqlSession.selectList(sql);

            /*
            * List<Student> studentList = dao.selectStudent()
            * 1.dao对象，类型事StudentDao，全限定名称是com.gracepowernode.dao.StudentDao
            *   全限定名称  和name 是一样的。
            *
            * 2.dao调用的方法名称 selectStudents，这个方法就是mapper文件中的 id值 selectStudents
            *
            * 3.通过dao中方法的返回值，也可以确定MyBatis要调用的SqlSession的方法
            *   如果返回值是List，调用的是SqlSession.selectList()方法。
            *   如果返回值是int，或是非List的，看mapper文件中的 标签是<insert>，<update>
            *   就会调用SqlSession的insert，update等方法。
            *
            *   mybatis的动态代理：mybatis 根据 dao的方法调用，获取执行sql语句的信息。
            *       mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象（类似daoimpl）
            *       完整SqlSSession调用方法，访问数据库。
            * */

            System.out.println("插入后，表数据如下所示:");
            for(Student stu : studentList){
                System.out.println(stu);
            }
        }
        else{
            System.out.println("数据插入失败!");
        }
    }
}
