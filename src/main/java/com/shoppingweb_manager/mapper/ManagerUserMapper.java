package com.shoppingweb_manager.mapper;

import com.shoppingweb.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ManagerUserMapper {

    /**
     *
     */
    @Select("select * from ec_user where login_name = #{loginName} and password = #{password}")
    User getUserByNameAndPass(User user);

    /**
     *
     */
    @Insert("insert into ec_user(login_name,password,name,sex,email,phone,address,create_date,active)  values(#{loginName},#{password},#{name},#{sex},#{email},#{phone},#{address},#{createDate},#{active})")
    void saveUser(User user);

    /**
     * 用户信息激活
     */
    @Update("update ec_user set disabled = '1' where active = #{activeCode}")
    void activeUser(String activeCode);

    /**
     * 根据账号获取用户信息
     */
    @Select("select * from ec_user where login_name = #{loginName}")
    User getUserByLoginName(String loginName);

    //获取所有用户信息
    List<User> userList(String name);

    //用户信息激活或者冻结
    @Update("update ec_user set disabled = #{disabled} where  id = #{id}")
    void activeServlet(User user);

}
