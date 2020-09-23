package com.xlccc.linkershiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Linker
 * @date 2020/9/23 21:05
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    private Integer id;
    private String permission;
    private String url;
    @TableField(exist=false)
    private Set<Role> roles = new HashSet<>();
}
