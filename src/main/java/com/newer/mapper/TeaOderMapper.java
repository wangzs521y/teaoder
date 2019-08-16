package com.newer.mapper;

import com.newer.domain.TeaOder;
import org.apache.ibatis.annotations.Insert;

public interface TeaOderMapper {

    @Insert("insert into tea (detail,num,price) values(#{detail},#{num},#{price})")
    int addOder(TeaOder teaOder);


}
