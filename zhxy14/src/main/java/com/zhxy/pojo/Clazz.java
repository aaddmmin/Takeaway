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
@TableName("tb_clazz")
@ApiModel
public class Clazz {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "班级主键")
    private Integer id;
    @ApiModelProperty(value = "班级名称")
    private String name;
    @ApiModelProperty(value = "班级人数")
    private Integer number;
    @ApiModelProperty(value = "班级介绍")
    private String introducation;
    @ApiModelProperty(value = "班主任姓名")
    private String headmaster;
    @ApiModelProperty(value = "班主任邮箱")
    private String email;
    @ApiModelProperty(value = "班主任电话")
    private String telephone;
    @ApiModelProperty(value = "当前班级所属年级")
    private String gradeName;
}
