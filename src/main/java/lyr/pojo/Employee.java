package lyr.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @Author lyr
 * @create 2020/1/21 12:32
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tbl_employee")

public class Employee {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "last_name",exist = true)//默认为true
    private String lastName;
    private String email;
    private String gender;

    private LocalDate birthday;
}
