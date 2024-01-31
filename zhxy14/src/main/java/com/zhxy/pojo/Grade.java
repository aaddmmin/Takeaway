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
@TableName("tb_grade")
@ApiModel
public class Grade {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "年级主键")
    private Integer id;
    @ApiModelProperty(value = "年级名称")
    private String name;
    @ApiModelProperty(value = "年级主任")
    private String manager;
    @ApiModelProperty(value = "年级主任邮箱")
    private String email;
    @ApiModelProperty(value = "年级主任电话")
    private String telephone;
    @ApiModelProperty(value = "年级介绍")
    private String introducation;
}
