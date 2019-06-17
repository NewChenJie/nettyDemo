package com.cj.service.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2019-05-11 13:16
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoVo {
    private Integer id;
    private String key;
    private String value;
    private String remark;
}
