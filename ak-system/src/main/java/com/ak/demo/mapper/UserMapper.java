package com.ak.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ak.demo.domain.User;

@Mapper
public interface UserMapper {

    @Select({
            "select * from user"
    })
    List<User> listAll();

    @Insert({
            "insert into user(account, username, password, role, gmt_create, gmt_modified) values(#{username},#{username}, #{password}, 1, now(), now())"
    })
    int insert(User user);

    @Delete({
            "delete from user where id = #{userId}"
    })
    int remove(Integer userId);

    @Update({
            "update user set username = #{username}, password = #{password} where id = #{id}"
    })
    int update(User user);

}
