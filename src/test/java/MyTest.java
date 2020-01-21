import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lyr.dao.EmployeeDao;
import lyr.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;


/**
 * @Author lyr
 * @create 2020/1/21 0:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class MyTest {
    @Autowired
    private EmployeeDao employeeDao;

    @org.junit.Test
    public void test()
    {
        Employee e = new Employee().setEmail("111@qq.com")
                .setLastName("hero")
                .setGender("男")
                .setBirthday(LocalDate.of(2000,5,4));
        employeeDao.myInsertOne(e);

        System.out.println(e);
    }








    @Test
    public void testGenerator() {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        //是否支持AR模式
        config.setActiveRecord(true)
                .setAuthor("weiyunhui") //作者
                .setOutputDir("F:\\我的编程小练习\\demo4\\src\\main\\java")  //生成路径
                .setFileOverride(true)//是否文件覆盖，如果多次
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO) //主键策略
                .setServiceName("%sService")//设置生成的service接口的名字的首字母是否为I
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/mybatis")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("422525");
        //3.策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) //表名 字段名 是否使用下滑线命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tbl_employee") //生成的表
                .setTablePrefix("tbl_"); // 表前缀
        //4.包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("lyr")//父包名
                .setController("controller")
                .setEntity("beans")
                .setService("service")
                .setMapper("mapper")
                .setXml("mapper");
        //5.整合配置
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        ag.execute();
    }
}
