package com.xiaolu.huiapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaolu.huiapicommon.model.entity.InterfaceInfo;

/**
* @author 16385
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-12-22 11:50:26
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
