package com.coding.service;

import com.coding.domain.Sensordata;
import com.coding.mapper.SensorDataMapper;
import com.guanweiming.common.utils.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class SensorDataService {

    private final SensorDataMapper sensordataMapper;
    public Result<List<Sensordata>> getsensor(String BridgeId,String MonitorId) {
        Sensordata record = new Sensordata();
        record.setBridgeId(BridgeId);
        record.setMonitorId(MonitorId);

        List<Sensordata> list = sensordataMapper.select(record);
        return Result.createBySuccess(list);
    }


//    public Result<List<Sensordata>> getdata200(String sensor_id,String bridge_id) {
//        List<Sensordata> list = sensordataMapper.get200data(sensor_id,bridge_id);
//        return Result.createBySuccess(list);
//    }
    public Result<List<Sensordata>> getdata(String monitorId,String bridgeId) {
    List<Sensordata> list = sensordataMapper.getdata(monitorId,bridgeId);
    return Result.createBySuccess(list);
}
}
