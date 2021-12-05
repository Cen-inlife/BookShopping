package com.shoppingweb.mapper;

import com.shoppingweb.bean.Article;
import com.shoppingweb.util.pager.PageModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {

    /**
     * 根据商品类型获取商品信息
     */
    List<Article> findAllArticle(@Param("typeCode")String typeCode, @Param("keyword")String keyword, @Param("pageModel") PageModel pageModel);

    /**
     * 根据商品id获取商品详情信息
     */
    @Select("select * from ec_article where id = #{id}")
    Article getArticleById(Integer id);

    /**
     * 查询总记录数
     */
    int findTotalNum(@Param("typeCode")String typeCode, @Param("keyword")String keyword);

}
