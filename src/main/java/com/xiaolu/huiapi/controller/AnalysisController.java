package com.xiaolu.huiapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaolu.huiapi.annotation.AuthCheck;
import com.xiaolu.huiapi.common.BaseResponse;
import com.xiaolu.huiapi.common.ErrorCode;
import com.xiaolu.huiapi.common.ResultUtils;
import com.xiaolu.huiapi.exception.BusinessException;
import com.xiaolu.huiapi.mapper.UserInterfaceInfoMapper;
import com.xiaolu.huiapi.model.vo.InterfaceInfoVO;
import com.xiaolu.huiapi.service.InterfaceInfoService;
import com.xiaolu.huiapicommon.model.entity.InterfaceInfo;
import com.xiaolu.huiapicommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/21 22:37
 * @Description 分析控制器
 */
@RestController
@RequestMapping("analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        // 查询interfaceInfo 的 id， 再根据 id 进行分组并排序
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        // 根据interfaceInfo 的 id 去查询更加详细的interfaceInfo信息
        LambdaQueryWrapper<InterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(InterfaceInfo::getId, interfaceInfoObjMap.keySet());
        List<InterfaceInfo> interfaceInfoList = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(interfaceInfoList)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = interfaceInfoList.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());

        return ResultUtils.success(interfaceInfoVOList);
    }

}
