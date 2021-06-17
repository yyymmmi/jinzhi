package com.coding.mapper;

import com.coding.domain.Artificialdata;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface ArtificialDataMapper extends Mapper<Artificialdata>, SelectByIdListMapper<Artificialdata,Long> {
}
