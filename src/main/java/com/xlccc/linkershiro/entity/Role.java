package com.xlccc.linkershiro.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Linker
 * @date 2020/9/23 21:03
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Integer id;
    private String name;
    @TableField(exist=false)
    private Set<Permission> permissions = new HashSet<>();
    @TableField(exist=false)
    private Set<User> users = new HashSet<>();
}
