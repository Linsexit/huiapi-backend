package com.xiaolu.huiapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolu.huiapi.common.ErrorCode;
import com.xiaolu.huiapi.exception.BusinessException;
import com.xiaolu.huiapi.mapper.InterfaceInfoMapper;
import com.xiaolu.huiapicommon.model.entity.InterfaceInfo;
import com.xiaolu.huiapicommon.model.entity.User;
import com.xiaolu.huiapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/20 13:38
 * @Description
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaQueryWrapper<InterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InterfaceInfo::getUrl, url);
        queryWrapper.eq(InterfaceInfo::getMethod, method);
        return interfaceInfoMapper.selectOne(queryWrapper);

    }
}
