package com.xiaolu.huiapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaolu.huiapi.common.ErrorCode;
import com.xiaolu.huiapi.exception.BusinessException;
import com.xiaolu.huiapi.exception.ThrowUtils;
import com.xiaolu.huiapi.mapper.UserInterfaceInfoMapper;
import com.xiaolu.huiapi.service.UserInterfaceInfoService;
import com.xiaolu.huiapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author 16385
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2024-01-15 00:56:30
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 创建时，校验接口和创建人
        if (add) {
            ThrowUtils.throwIf((userInterfaceInfo.getUserId() <= 0) || (userInterfaceInfo.getInterfaceInfoId() <= 0), ErrorCode.PARAMS_ERROR, "接口或用户不存在");
        }
        // 有参数则校验
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }

    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.gt("leftNum", 0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");

        return this.update(updateWrapper);
    }
}




