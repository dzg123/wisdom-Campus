package com.dzg.springarcgis.mapper;

import com.dzg.springarcgis.domain.Location;
import org.apache.ibatis.annotations.*;

public interface LocationMapper {
    @Select("select * from location where userId=#{id}")
    public Location getCoordinateByUserId(String id);

    @Delete("delete from location where id=#{id}")
    public int deleteLocationById(String id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into location(userId,coordinate,time,user_ip,state) values(#{userId}," +
            "#{coordinate},#{time},#{userIp},#{state})")
    public int insertLocation(Location location);

}
