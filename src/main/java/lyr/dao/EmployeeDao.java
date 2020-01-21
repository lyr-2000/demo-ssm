package lyr.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import lyr.pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author lyr
 * @create 2020/1/21 13:50
 *
 * employee表 的属性有 ： id、 last_name、 gender、 email
 *
 */

public interface EmployeeDao extends BaseMapper<Employee> {

    @Select("select * from tbl_employee")
    List<Employee> mySelectAll();

    @Select("select * from tbl_employee where ${column}= #{value}")
    List<Employee> myFindByColumn(@Param("column")String column,@Param("value") String value);


    /**
     * 插入一条数据并且返回 id,把 id存入 employee 对象中
     * @param employee
     */
    @Insert({"insert into tbl_employee (id,last_name,gender,email)values(#{i.id},#{i.lastName},#{i.gender},#{i.email})"})
    @SelectKey(statement = "select last_insert_id()" ,keyProperty = "i.id",keyColumn = "id",resultType = Integer.class,before = false)
    void myInsertOne (@Param("i") Employee employee);/* param 的参数是 sql语句中的对象名字 */


    /**
     * 通过 Mapper 配置文件声明sql语句
     * @return 返回集合
     */
//    下面是使用 mapper 配置的方法
    List<Employee> mySelectList();
}
