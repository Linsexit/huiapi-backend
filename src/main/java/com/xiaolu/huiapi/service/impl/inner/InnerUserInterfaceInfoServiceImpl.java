package com.xiaolu.huiapi.service.impl.inner;

import com.xiaolu.huiapi.service.UserInterfaceInfoService;
import com.xiaolu.huiapicommon.model.entity.UserInterfaceInfo;
import com.xiaolu.huiapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/20 14:00
 * @Description
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
