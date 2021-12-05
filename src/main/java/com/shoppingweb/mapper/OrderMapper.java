package com.shoppingweb.mapper;

import com.shoppingweb.bean.Order;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {

    /**
     * 保存订单信息
     */
    void saveOrder(Order order);

    /**
     * 根据用户id获取该用户所有的订单信息
     */
    List<Order> getOrdersByUserId(int userId);

    //修改订单状态
    @Update("update ec_order set pay_status = '1' where order_code = #{orderNo}")
    void updateOrderPayOrderNo(String orderNo);

}
