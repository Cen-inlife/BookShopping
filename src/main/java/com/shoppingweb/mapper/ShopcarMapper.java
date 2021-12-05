package com.shoppingweb.mapper;

import com.shoppingweb.bean.Shopcar;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopcarMapper {

    /**
     *
     */
    @Select("select * from ec_shopcar where user_id = #{userId} and article_id=#{id}")
    Shopcar getShopCarByUserIdAndArticleId(@Param("userId")int userId, @Param("id")int id);

    /**
     *
     */
    @Update("update ec_shopcar set buynum = #{number} + buynum where user_id = #{userId} and article_id=#{id}")
    void updateShopCar(@Param("userId")int userId, @Param("id")int id, @Param("number")int number);

    /**
     *
     */
    @Insert("insert into ec_shopcar(buynum,user_id,article_id) values(#{number},#{userId},#{id})")
    void addShopCar(@Param("userId")int userId, @Param("id")int id, @Param("number")int number);

    /**
     * 获取用户的购物详情信息
     */
    List<Shopcar> getAllShopCarByUserId(int userId);

    /**
     *
     */
    @Update("update ec_shopcar set buynum = #{buyNum}  where user_id = #{userId} and article_id=#{id}")
    void updateShopcar(@Param("userId")int userId, @Param("id")int id, @Param("buyNum")int buyNum);

    /**
     *
     */
    @Delete("delete from ec_shopcar where user_id = #{userId} and article_id=#{id}")
    void deleteShopcar(@Param("userId")int userId, @Param("id")int id);

}
