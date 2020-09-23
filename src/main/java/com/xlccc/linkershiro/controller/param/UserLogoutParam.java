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
@ApiModel(description = "用户退出")
public class UserLogoutParam {
    @ApiModelProperty("用户名称")
    String userName;

}