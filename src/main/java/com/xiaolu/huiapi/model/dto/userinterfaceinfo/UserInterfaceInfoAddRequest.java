package com.xiaolu.huiapi.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author 林小鹿

 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 创建人id
     */
    private Long userId;

    /**
     * 接口id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;


    private static final long serialVersionUID = 1L;

}