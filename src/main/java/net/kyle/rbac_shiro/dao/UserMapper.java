package net.kyle.rbac_shiro.dao;

import net.kyle.rbac_shiro.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username")String username);



    @Select("select * from user where id=#{userId}")
    User findById(@Param("userId") int id);



    @Select("select * from user where username = #{username} and password = #{pwd}")
    User findByUsernameAndPwd(@Param("username")String username, @Param("pwd")String pwd);



}
