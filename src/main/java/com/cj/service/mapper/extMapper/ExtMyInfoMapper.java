package com.cj.service.mapper.extMapper;

import com.cj.service.domain.vo.InfoVo;
import com.cj.service.mapper.MyInfoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created with Mybatis Generator Plugin
 *
 * @author MiaoWoo
 * Created on 2019/05/11 11:22.
 */
@Repository
public interface ExtMyInfoMapper extends MyInfoMapper{

    InfoVo getInfoByKeyLike(String key);

    List<String> getKeys();

    InfoVo getInfoByKey(String key);
}