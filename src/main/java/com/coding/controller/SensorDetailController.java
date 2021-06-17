package com.coding.controller;

import com.coding.common.Const;
import com.coding.common.PageParam;
import com.coding.domain.Bridge;
import com.coding.domain.Sensordata;
import com.coding.domain.Sensordetail;
import com.coding.domain.User;
import com.coding.mapper.BridgeMapper;
import com.coding.mapper.SensorDataMapper;
import com.coding.mapper.SensorDetailMapper;
import com.coding.mapper.UserMapper;
import com.coding.service.BridgeService;
import com.coding.service.SensorDataService;
import com.coding.service.SensorDetailService;
import com.coding.service.UserService;
import com.github.pagehelper.PageHelper;
import com.guanweiming.common.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Api(tags = "传感器信息  接口")
@AllArgsConstructor
@RequestMapping(Const.API + "sensorinf")
@RestController
public class SensorDetailController {

    private final SensorDetailService sensorDetailService;
    private final SensorDetailMapper sensorDetailMapper;

    @ApiOperation("查询传感器的信息")
    @GetMapping("alldata")
    //PageParam pageParam
    public Result<List<Sensordetail>> allsensorinf() {
        //    PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), "id desc");
        return Result.createBySuccess(sensorDetailMapper.selectAll());
    }


    @ApiOperation("查询对应传感器数信息")
    @GetMapping("getsensorinf")
    public Result<Sensordetail> Selectsensorinf(@RequestParam String SensorId) {
        return sensorDetailService.getsensordetail(SensorId);
    }

}
