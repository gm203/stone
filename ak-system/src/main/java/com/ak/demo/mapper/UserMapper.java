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
            "select * from test_user"
    })
    List<User> listAll();

    @Insert({
            "insert into test_user values(#{username},#{username}, #{password})"
    })
    Integer insert(User user);

    @Delete({
            "delete from test_user where account = #{account}"
    })
    Integer remove(Integer userId);

    @Update({
            "update test_user set username = #{username}, password = #{password} where account = #{account}"
    })
    Integer update(User user);

}
