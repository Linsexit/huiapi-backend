package com.xiaolu.huiapicommon.service;

import com.xiaolu.huiapicommon.model.entity.InterfaceInfo;

/**
* @author 16385
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-12-22 11:50:26
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法、请求参数）
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);


}
