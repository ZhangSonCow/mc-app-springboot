package com.coldsink.mapper;

import com.coldsink.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user_table")
    List<User> list();

    @Select("select * from user_table where username = #{username} and password = #{password}")
    User geyByUsernameAndPassword(User emp);
}
