package com.xiaolu.huiapicommon.service;


/**
* @author 16385
* @description 公共服务方法
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 接口统计调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
