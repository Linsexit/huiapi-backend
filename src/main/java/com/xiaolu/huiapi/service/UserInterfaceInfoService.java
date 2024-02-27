package com.xiaolu.huiapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaolu.huiapicommon.model.entity.UserInterfaceInfo;

/**
* @author 16385
* @description 公共服务方法
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 校验
     *
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 接口统计调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

}
