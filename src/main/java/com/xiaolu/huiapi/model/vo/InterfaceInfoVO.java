package com.xiaolu.huiapi.model.vo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xiaolu.huiapi.model.entity.Post;
import com.xiaolu.huiapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 接口信息封装视图
 *
 * @author 林小鹿

 */
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

}
