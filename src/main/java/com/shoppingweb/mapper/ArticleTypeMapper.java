package com.shoppingweb.mapper;

import com.shoppingweb.bean.ArticleType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleTypeMapper {

    /**
     * 获取所有的一级物品类型
     */
    @Select("select * from ec_article_type where length(code) = 4")
    List<ArticleType> findAllFirstArticleType();

    /**
     * 根据一级物品类型获取对应的二级物品类型信息
     */
    @Select("select * from ec_article_type where code like #{typeCode} and length(code) =8")
    List<ArticleType> findAllSecondArticleTypes(String typeCode);

}
