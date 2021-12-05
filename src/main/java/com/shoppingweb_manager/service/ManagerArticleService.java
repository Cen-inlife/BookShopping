package com.shoppingweb_manager.service;

import com.shoppingweb.bean.Article;
import com.shoppingweb_manager.util.pager.PageModel;


import java.util.List;

public interface ManagerArticleService {

    /**
     * 根据商品类型以及商品的标题获取商品信息
     */
    List<Article> getAllArticles(String typeCode, String title, PageModel pageModel);

    /**
     * 根据商品id获取商品信息
     */
    Article getArticleById(Integer id);

    /**
     * 商品信息下架
     */
    void removeArticleById(Integer id);

    /**
     * 保存商品信息
     */
    void saveArticle(Article article);

    /**
     * 更新商品信息
     */
    void updateArticle(Article article);

    //加载二级类型
    String ajaxLoadSeTypes(String code);

}
