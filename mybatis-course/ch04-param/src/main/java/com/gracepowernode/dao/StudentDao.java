package com.gracepowernode.dao;

import com.gracepowernode.domain.Student;
import com.gracepowernode.ov.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    /*
    * 一个 简单类型 的参数：
    *   简单类型：mybatis把java的基本数据类型和String都叫简单类型。
    *   在mapper文件获取简单类型的一个参数的值，使用#{任意字符}
    *
    * */
    public Student selectStudentById(Integer id);


    /*
    * 实现多个参数：命名参数，在形参定义的前面 加入 @Param("自定义名称")
    * */
    public List<Student> selectMulitParam(@Param("myname") String name, @Param("myage") Integer age);

    /*
    * 多个参数，使用java对象作为接口中方法的参数
    * */
    List<Student> selectMultiObject(QueryParam paramqp);

    List<Student> SelectUse$Order(@Param("colName") String colName);
}
