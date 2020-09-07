package com.sunuping.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author lime
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value="User对象", description="用户")
public class User implements Serializable {

    private static final long serialVersionUID = 2662143963539001000L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;

    @ApiModelProperty(value = "头像")
    private String avater;

    @ApiModelProperty(value = "是否启用 默认启用 1 禁用0")
    private Boolean isEnable;

    @ApiModelProperty(value = "是否删除 默认0  删除1")
    private Boolean isDel;

    @ApiModelProperty(value = "插入时间")
    private Date insertTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
