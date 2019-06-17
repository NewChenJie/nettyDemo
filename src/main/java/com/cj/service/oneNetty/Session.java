package com.cj.service.oneNetty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chenjie
 * @date : 2019-06-14 13:23
 * @describe :
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    private String userId;
    private String userName;
}
