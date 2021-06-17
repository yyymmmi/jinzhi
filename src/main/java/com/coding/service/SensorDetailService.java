package com.coding.service;

import com.coding.domain.Bridge;
import com.coding.domain.Sensordata;
import com.coding.domain.Sensordetail;
import com.coding.domain.User;
import com.coding.mapper.BridgeMapper;
import com.coding.mapper.SensorDataMapper;
import com.coding.mapper.SensorDetailMapper;
import com.guanweiming.common.utils.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class SensorDetailService {

    private final SensorDetailMapper sensorDetailMapper;
    public Result<Sensordetail> getsensordetail(String sensorId) {
        Sensordetail record = new Sensordetail();
        record.setSensorId(sensorId);
        List<Sensordetail> list = sensorDetailMapper.select(record);
        return  Result.createBySuccess( list.size() == 0 ? null : list.get(0));
    }
}
