package com.coding.controller;

import com.coding.common.Const;
import com.coding.common.PageParam;
import com.coding.domain.Artificialdata;
import com.coding.domain.Bridge;
import com.coding.domain.Sensordata;
import com.coding.domain.User;
import com.coding.mapper.ArtificialDataMapper;
import com.coding.mapper.BridgeMapper;
import com.coding.mapper.SensorDataMapper;
import com.coding.mapper.UserMapper;
import com.coding.service.ArtificialDataService;
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
@Api(tags = "人工数据接口")
@AllArgsConstructor
@RequestMapping(Const.API + "artificialdata")
@RestController
public class ArtificialDataController {
    private final ArtificialDataService artificialDataService;
    private final ArtificialDataMapper artificialDataMapper;

    @ApiOperation("查询所有人工巡检数据")
    @GetMapping("alldata")
    public Result<List<Artificialdata>> alldata(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), "id");
        return Result.createBySuccess(artificialDataMapper.selectAll());
    }

    @ApiOperation("提交人工巡检数据")
    @GetMapping("upload")
    public Result<Artificialdata> upload( String disease_loc,
                                            String disease_data,
                                            String disease_evaluate,
                                            String supplementary_notes,
                                            String inspection_time,
                                            String inspector_id,
                                            @RequestParam Long id
                                            ) {
        return artificialDataService.addData(disease_loc, disease_data, disease_evaluate, supplementary_notes,
                inspection_time, inspector_id,id);
    }

    @ApiOperation("修改人工巡检数据")
    @GetMapping("update")
    public Result<Artificialdata> update(   String disease_loc,
                                            String disease_data,
                                            String disease_evaluate,
                                            String supplementary_notes,
                                            String inspection_time,
                                            String inspector_id,
                                            @RequestParam Long id
    ) {
        return artificialDataService.updateData(disease_loc, disease_data, disease_evaluate, supplementary_notes,
                inspection_time, inspector_id,id);
    }



}
