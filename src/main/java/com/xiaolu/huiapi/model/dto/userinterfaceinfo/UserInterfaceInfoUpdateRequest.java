package com.xiaolu.huiapi.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author 林小鹿

 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;


    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 接口状态（0-正常，1-禁用）
     */
    private Integer status;


    private static final long serialVersionUID = 1L;
}