package com.coding.mapper;

import com.coding.domain.Sensordata;
import com.coding.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface UserMapper extends Mapper<User>, SelectByIdListMapper<User,Long> {
    @Select("select * from user_detail")
    List<User> test();
    @Select("select count(username) from user_detail")
    int getnum();

}
