package com.coding.service;

import com.coding.domain.Bridge;
import com.coding.domain.Sensordata;
import com.coding.domain.User;
import com.coding.mapper.BridgeMapper;
import com.coding.mapper.SensorDataMapper;
import com.guanweiming.common.utils.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class BridgeService {

    private final BridgeMapper bridgeMapper;
    public Result<Bridge> getbridge(String BridgeId) {
        Bridge record = new Bridge();
        record.setBridgeId(BridgeId);
        List<Bridge> list = bridgeMapper.select(record);
        return  Result.createBySuccess( list.size() == 0 ? null : list.get(0));
    }

    public Result<Bridge> addbridge(String bridge_name, String bridge_id, String bridge_loc, String bridge_inf) {
        Bridge record = new Bridge();
        record.setBridgeId(bridge_id);
        List<Bridge> list = bridgeMapper.select(record);
        if (!CollectionUtils.isEmpty(list)) {
            return Result.createByErrorMessage("桥梁已经存在，无法添加");
        }
        record.setBridgeName(bridge_name);
        record.setBridgeLoc(bridge_loc);
        record.setBridgeInf(bridge_inf);

        int resultCount = bridgeMapper.insertSelective(record);
        return resultCount == 0 ? Result.createByErrorMessage("添加失败") : Result.createBySuccess(record);
    }

    public Result<Bridge> uploadbridge(String bridge_name, String bridge_id, String bridge_loc, String bridge_inf) {
        Bridge record = new Bridge();
        record.setBridgeId(bridge_id);
        List<Bridge> list = bridgeMapper.select(record);
        if (CollectionUtils.isEmpty(list)) {
            return Result.createByErrorMessage("桥梁不存在，无法修改");
        }
        record.setBridgeName(bridge_name);
        record.setBridgeLoc(bridge_loc);
        record.setBridgeInf(bridge_inf);

        int resultCount = bridgeMapper.updateByPrimaryKeySelective(record);
        return resultCount == 0 ? Result.createByErrorMessage("添加失败") : Result.createBySuccess(record);


    }
}
