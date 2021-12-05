package com.shoppingweb_manager.service;

import com.shoppingweb.bean.Order;
import com.shoppingweb_manager.util.pager.PageModel;

import java.util.List;

public interface ManagerOrderService {

    /**
     * 订单分页查询
     */
    List<Order> getAll(PageModel pageModel);

    /**
     * 确认发送订单
     */
    void checkOrder(Order order);

}
