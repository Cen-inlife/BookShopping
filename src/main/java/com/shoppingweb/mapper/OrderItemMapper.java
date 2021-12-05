package com.shoppingweb.mapper;

import com.shoppingweb.bean.OrderItem;
import org.apache.ibatis.annotations.Insert;

public interface OrderItemMapper {

    /**
     * 保存订单明细
     */
    @Insert("insert into ec_order_item(order_id,article_id,order_num) values(#{orderId},#{articleId},#{orderNum}) ")
    void saveItem(OrderItem item);

}
