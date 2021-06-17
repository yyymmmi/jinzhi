package com.coding.mapper;

import com.coding.domain.Sensordata;
import com.coding.domain.User;
import com.guanweiming.common.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;



@Repository
public interface SensorDataMapper extends Mapper<Sensordata>, SelectByIdListMapper<Sensordata,Long> {
    @Select("SELECT * from(SELECT * from sensor_data1 WHERE monitor_id=#{monitorId} AND bridge_id=#{bridgeId} ORDER BY monitor_time DESC LIMIT 0,499)T ORDER BY monitor_time")


    List<Sensordata> getdata(@Param("monitorId") String monitorId, @Param("bridgeId") String bridgeId);
//       @Select("select * from sensor_data1")
//        List<Sensordata> getdata();
}

