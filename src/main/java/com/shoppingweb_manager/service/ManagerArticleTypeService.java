package com.shoppingweb_manager.service;

import com.shoppingweb.bean.ArticleType;
import com.shoppingweb_manager.util.pager.PageModel;

import java.util.List;

public interface ManagerArticleTypeService {

    /**
     * @return
     * 获取所有的一级商品类型
     */
    List<ArticleType> findAllFirstArticleType();

    /**
     * 根据商品类型以及商品的标题获取商品信息
     */
    List<ArticleType> getAllArticleTypes(PageModel pageModel);

    /**
     * 加载修改商品类型页面
     */
    ArticleType getArticleTypeByCode(String code);

    /**
     * 进行更新商品类型操作
     */
    void updateArticleType(ArticleType type);

    /**
     *  进行添加商品类型操作
     */
    void saveArticleType(ArticleType type, String parentCode);

    /**
     * 删除商品类型
     */
    String deleteType(String code);

}
