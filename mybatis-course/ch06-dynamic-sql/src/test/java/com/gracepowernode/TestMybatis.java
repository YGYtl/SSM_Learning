package com.gracepowernode;

import com.github.pagehelper.PageHelper;
import com.gracepowernode.dao.StudentDao;
import com.gracepowernode.domain.Student;
import com.gracepowernode.ov.QueryParam;
import com.gracepowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestMybatis {
    @Test
    public void TestselectStudentIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam qpstudent = new QueryParam();
        qpstudent.setParamName("王五");
        qpstudent.setParamAge(29);
        List<Student> studentList = dao.selectStudentIf(qpstudent);
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void TestselectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam qpstudent = new QueryParam();
        qpstudent.setParamName("王五");
        qpstudent.setParamAge(29);
        List<Student> studentList = dao.selectStudentWhere(qpstudent);
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        //String sql = "select * from student where id in (1001,1002,1003)";
        String sql = "select * from student where id in ";
        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();

        builder.append("(");
        for(Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        sql = sql + builder.toString();
        System.out.println(sql);
    }

    @Test
    public void TestselectForeachOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> studentList = dao.selectForeachOne(list);
        for(Student stu : studentList){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectForeachTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student stu = new Student();
        stu.setId(1001);
        list.add(stu);

        stu = new Student();;
        stu.setId(1005);
        list.add(stu);
        List<Student> studentList = dao.selectForeachTwo(list);
        for(Student stu2 : studentList){
            System.out.println(stu2);
        }
        sqlSession.close();
    }


    @Test
    public void TestselectAllStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        /*
        * 加入PageHelper的方法，分页
        * pageNum：第几页，从1开始
        * pageSize：一页中有多少行数据
        * */

        PageHelper.startPage(2,3);
        List<Student> stulist = dao.selectAllStudent();

        stulist.forEach(stu -> System.out.println(stu));

        sqlSession.close();
    }

}
