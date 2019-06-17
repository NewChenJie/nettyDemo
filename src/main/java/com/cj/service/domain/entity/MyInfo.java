package com.cj.service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Mybatis Generator Plugin
 *
 * @author MiaoWoo
 * Created on 2019/05/11 11:22.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyInfo {
    private Integer id;

    private String key;

    private String value;

    private String remark;
}