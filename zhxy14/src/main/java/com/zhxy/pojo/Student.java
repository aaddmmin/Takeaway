package com.zhxy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_student")
@ApiModel
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "学生主键")
    private Integer id;
    @ApiModelProperty(value = "学号")
    private Integer sno;
    @ApiModelProperty(value = "性别")
    private String name;
    @ApiModelProperty(value = "性别")
    private Character gender;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "学生地址")
    private String address;
    @ApiModelProperty(value = "学生介绍")
    private String introducation;
    @ApiModelProperty(value = "学生头像图片路径")
    private String portraitPath;
    @ApiModelProperty(value = "学生所在的班级")
    private String clazzName;
}
