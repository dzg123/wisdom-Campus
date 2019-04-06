package com.dzg.springarcgis.mapper;

import com.dzg.springarcgis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User getUserByUserName(String username);
    @Select("select * from user where phone=#{phone}")
    User getUserByPhone(String phone);
    @Select("select id from user where phone=#{phone}")
    int getIdByPhone(String phone);
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(username,password,email,phone,role,state,nickname) " +
            "values(#{username},#{password},#{email},#{phone},#{role},#{state},#{nickname})")
    int insertUser(User user);

}
