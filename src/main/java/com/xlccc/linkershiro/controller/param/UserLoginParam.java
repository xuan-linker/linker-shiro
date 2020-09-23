package com.xlccc.linkershiro.controller.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Linker
 * @date 2020/9/23 21:00
 * @description：
 */
@Data
@ApiModel(description = "用户登录")
public class UserLoginParam {
    @ApiModelProperty("用户名称")
    String userName;

    @ApiModelProperty("用户密码")
    String password;
}