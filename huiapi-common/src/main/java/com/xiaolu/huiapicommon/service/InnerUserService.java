package com.xiaolu.huiapicommon.service;

import com.xiaolu.huiapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author 林小鹿

 */
public interface InnerUserService {


    /**
     * 数据库中查是否已分配给用户密钥（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);



}
