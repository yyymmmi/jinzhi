package com.coding.mapper;

import com.coding.domain.Bridge;
import com.coding.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface BridgeMapper extends Mapper<Bridge>, SelectByIdListMapper<Bridge,Long> {
}
