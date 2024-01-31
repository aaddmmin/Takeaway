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
@TableName("tb_teacher")
@ApiModel
public class Teacher {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "教师主键")
    private Integer id;
    @ApiModelProperty(value = "教师编号")
    private Integer tno;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "性别")
    private Character gender;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "头像地址")
    private String portraitPath;
    @ApiModelProperty(value = "负责的班级")
    private String clazzName;
}
