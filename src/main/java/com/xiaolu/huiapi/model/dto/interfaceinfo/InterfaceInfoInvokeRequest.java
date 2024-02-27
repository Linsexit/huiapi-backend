package com.xiaolu.huiapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口调用请求
 *
 * @author 林小鹿

 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}