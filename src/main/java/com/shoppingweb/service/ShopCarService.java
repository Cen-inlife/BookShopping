package com.shoppingweb.service;

import com.shoppingweb.bean.Shopcar;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShopCarService {

    /**
     * 将商品信息加入至购物车
     */
    void addArticleToShopCar(HttpSession session, int id, int number);

    /**
     * 展示购物车中的商品信息
     */
    List<Shopcar> getAllShopCarByUserId(HttpSession session);

    /**
     * 更新购物车中商品的购物数量
     */
    void updateShopcar(HttpSession session, int id, int number);

    /**
     *删除购物车中商品的购物数量
     */
    void deleteShopcar(HttpSession session, int id);

}
