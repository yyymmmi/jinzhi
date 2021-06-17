package com.coding.controller;

import com.coding.common.Const;
import com.coding.common.PageParam;
import com.coding.domain.Sensordata;
import com.coding.mapper.SensorDataMapper;
import com.coding.service.SensorDataService;
import com.github.pagehelper.PageHelper;
import com.guanweiming.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Api(tags = "传感器数据接口")
@AllArgsConstructor
@RequestMapping(Const.API + "sensordata")
@RestController
public class SensorDataController {

    private final SensorDataService sensordataService;
    private final SensorDataMapper sensordataMapper;

    @ApiOperation("查询对应传感器数据")
    @GetMapping("sensorselect")
    public Result<List<Sensordata>> sensorselect(@RequestParam String BridgeId,
                                                 @RequestParam String SensorId) {
        return sensordataService.getsensor(BridgeId,SensorId);
    }

    @ApiOperation("查询500条传感器数据")
    @GetMapping("select500")
    public Result<List<Sensordata>> getdata(@RequestParam String SensorId,
                                               @RequestParam String BridgeId) {
        return sensordataService.getdata(SensorId,BridgeId);
    }


    @ApiOperation("查询所有的传感器数据")
    @GetMapping("alldata")
    public Result<List<Sensordata>> sensorselect(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), "data_id desc");
        return Result.createBySuccess(sensordataMapper.selectAll());
    }


}
