package com.xiaolu.huiapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaolu.huiapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author 16385
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2024-01-15 00:56:30
* @Entity com.xiaolu.huiapi.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    // select interfaceInfoId, sum(totalNum) as totalNum from user_interface_info group by interfaceInfoId order by totalNum desc limit 3;
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




