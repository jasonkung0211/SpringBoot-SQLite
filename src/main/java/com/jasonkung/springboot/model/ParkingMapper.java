package com.jasonkung.springboot.model;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface ParkingMapper {

    @Insert("INSERT OR REPLACE INTO parking(id, name, space) VALUES(" +
            "(SELECT id FROM parking WHERE name=#{name}), " +
            "#{name}, #{space})")
    int insert(Parking model);
}