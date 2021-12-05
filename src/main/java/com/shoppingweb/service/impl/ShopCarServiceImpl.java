package com.shoppingweb.service.impl;

import com.shoppingweb.bean.Shopcar;
import com.shoppingweb.bean.User;
import com.shoppingweb.mapper.ShopcarMapper;
import com.shoppingweb.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("shopCarServiceI")
@Transactional
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopcarMapper shopcarMapper;

    /*
     * 将商品信息加入至购物车
     */
    @Override
    public void addArticleToShopCar(HttpSession session, int id, int number) {
        // TODO Auto-generated method stub

        //从session中获取用户信息
        User user = (User)session.getAttribute("session_user");

        //获取用户的id
        int userId = user.getId();
        //根据用户id以及商品id从购物车表中获取相关信息
        Shopcar shopCar = shopcarMapper.getShopCarByUserIdAndArticleId(userId,id);

        if(shopCar!=null) {
            //该商品已经存在于当前用户的购车中，则进行商品数量的叠加
            shopcarMapper.updateShopCar(userId,id,number);
        }else {
            //该商品不存在与当前用户的购物车中
            shopcarMapper.addShopCar(userId,id,number);
        }

    }

    /*
     *
     */
    @Override
    public List<Shopcar> getAllShopCarByUserId(HttpSession session) {
        // TODO Auto-generated method stub
        //从session中获取用户信息
        User user = (User)session.getAttribute("session_user");

        //获取用户的id
        int userId = user.getId();

        //获取用户的购物详情信息
        List<Shopcar> shopcars = shopcarMapper.getAllShopCarByUserId(userId);
        return shopcars;
    }

    /*
     *更新购物车中商品的购物数量
     */
    @Override
    public void updateShopcar(HttpSession session, int id, int number) {
        // TODO Auto-generated method stub
        //从session中获取用户信息
        User user = (User)session.getAttribute("session_user");

        //获取用户的id
        int userId = user.getId();

        shopcarMapper.updateShopcar(userId,id,number);

    }

    /*
     *删除购物车中商品的购物数量
     */
    @Override
    public void deleteShopcar(HttpSession session, int id) {
        // TODO Auto-generated method stub
        //从session中获取用户信息
        User user = (User)session.getAttribute("session_user");

        //获取用户的id
        int userId = user.getId();

        shopcarMapper.deleteShopcar(userId,id);
    }


}
