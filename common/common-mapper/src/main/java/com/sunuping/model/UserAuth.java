package com.sunuping.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 第三方应用用户关联
 * </p>
 *
 * @author lime
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_auth")
@ApiModel(value="UserAuth对象", description="第三方应用用户关联")
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 2787937027127042748L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "第三方应用类型 0 微信 1 支付宝 2 QQ 3 微博 ")
    private Boolean type;

    @ApiModelProperty(value = "第三方唯一id")
    private String uniqueId;

    @ApiModelProperty(value = "第三方登录凭证 或者密码  或者token")
    private String loginCertificatecertificate;

    @ApiModelProperty(value = "插入时间")
    private Date insertTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
