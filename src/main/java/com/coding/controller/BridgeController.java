package com.coding.controller;

import com.coding.common.Const;
import com.coding.common.PageParam;
import com.coding.domain.Bridge;
import com.coding.domain.Sensordata;
import com.coding.domain.User;
import com.coding.mapper.BridgeMapper;
import com.coding.mapper.SensorDataMapper;
import com.coding.mapper.UserMapper;
import com.coding.service.BridgeService;
import com.coding.service.SensorDataService;
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
@Api(tags = "桥梁接口")
@AllArgsConstructor
@RequestMapping(Const.API + "bridge")
@RestController
public class BridgeController {

    private final BridgeService bridgeService;
    private final BridgeMapper bridgeDataMapper;

    @ApiOperation("查询桥梁的数据")
    @GetMapping("alldata")
    //PageParam pageParam
    public Result<List<Bridge>> allBridge() {
        //    PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), "id desc");
        return Result.createBySuccess(bridgeDataMapper.selectAll());
    }


    @ApiOperation("查询对应桥梁数据")
    @GetMapping("selectbridge")
    public Result<Bridge> bridgeselect(@RequestParam String BridgeId) {

        return bridgeService.getbridge(BridgeId);
    }

    @ApiOperation("添加桥梁")
    @GetMapping("addbridge")
    public Result<Bridge> addbrige( @RequestParam String bridge_name,
                                    @RequestParam String bridge_id,
                                     String bridge_loc,
                                     String bridge_inf) {

        return bridgeService.addbridge(bridge_name,bridge_id,bridge_loc,bridge_inf);
    }

    @ApiOperation("更改桥梁信息")
    @GetMapping("uploadbridge")
    public Result<Bridge> uploadbridge( String bridge_name,
                                       @RequestParam String bridge_id,
                                       String bridge_loc,
                                       String bridge_inf) {

        return bridgeService.uploadbridge(bridge_name,bridge_id,bridge_loc,bridge_inf);
    }

}
