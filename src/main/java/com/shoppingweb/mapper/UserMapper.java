package com.shoppingweb.mapper;

import com.shoppingweb.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    /**
     *根据用户输入的账号以及密码获取用户的信息
     */
    @Select("select * from ec_user where login_name = #{loginName} and password = #{password}")
    User findUserByNameAndPass(User user);

    /**
     * 验证登录名
     */
    @Select("select * from ec_user where login_name = #{loginName}")
    User validLoginName(String loginName);

    /**
     * 注册用户
     */
    @Insert("insert into ec_user(login_name,password,name,sex,email,phone,address,create_date,active) values(#{loginName},#{password},#{name},#{sex},#{email},#{phone},#{address},#{createDate},#{active})")
    void saveUser(User user);

    /**
     * 用户信息激活
     */
    @Update("update ec_user set disabled = 1 ,active = '' where active = #{activeCode}")
    void active(String activeCode);

    /**
     *
     */
    @Select("select * from ec_user where active = #{activeCode}")
    User getUserByActive(String activeCode);

    /**
     * 更新用户的信息
     */
    @Update("update  ec_user set name=#{name},password=#{password},sex=#{sex},email=#{email},phone=#{phone},address=#{address} where id = #{id}")
    void userUpdate(User user);

}
