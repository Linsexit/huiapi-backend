package com.xiaolu.huiapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolu.huiapi.common.ErrorCode;
import com.xiaolu.huiapi.exception.BusinessException;
import com.xiaolu.huiapi.mapper.UserMapper;
import com.xiaolu.huiapicommon.model.entity.User;
import com.xiaolu.huiapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/20 13:37
 * @Description
 */
@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccessKey, accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
