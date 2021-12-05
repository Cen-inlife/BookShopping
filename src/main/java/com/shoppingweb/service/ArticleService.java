package com.shoppingweb.service;

import com.shoppingweb.bean.Article;
import com.shoppingweb.bean.ArticleType;
import com.shoppingweb.util.pager.PageModel;

import java.util.List;

public interface ArticleService {

    /**
     * 获取所有的一级物品类型
     */
    List<ArticleType> findAllFirstArticleType();

    /**
     * 根据商品类型获取商品信息
     */
    List<Article> findAllArticle(String typeCode, String keyword, PageModel pageModel);

    /**
     * 根据一级物品类型获取对应的二级物品类型信息
     */
    List<ArticleType> findAllSecondArticleTypes(String string);

    /**
     * 根据商品id获取商品详情信息
     */
    Article getArticleById(Integer id);

    /**
     * 查询总记录数
     */
    int findTotalNum(String typeCode, String keyword);


}
