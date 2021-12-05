package com.shoppingweb_manager.mapper;

import com.shoppingweb.bean.Article;
import com.shoppingweb.bean.ArticleType;
import com.shoppingweb_manager.util.pager.PageModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ManagerArticleMapper {

    List<Article> getAllArticles(@Param("typeCode")String typeCode, @Param("title")String tite, @Param("pageModel") PageModel pageModel);

    /**
     * 根据商品id获取商品信息
     */
    @Select("select * from  ec_article where id = #{id}")
    Article getArticleById(Integer id);

    /**
     * @param id
     */
    @Update("update ec_article set disabled = '1' where id = #{id}")
    void removeArticleById(Integer id);

    /**
     * 进行分页查询之前获取总记录数
     */
    int getTotalNum(@Param("typeCode")String typeCode,@Param("title")String tite);

    /**
     * 保存商品信息
     */
    void saveArtice(Article article);

    /**
     * 更新商品信息
     */
    void updateArticle(Article article);

    //判断商品类型下是否有商品关联到该商品类型
    @Select("select * from  ec_article where type_code = #{code}")
    List<Article> getArticleByType(String code);

    //加载二级商品类型
    @Select("select * from ec_article_type where code like #{code} and length(code) = 8 ")
    List<ArticleType> ajaxLoadSeTypes(String string);


}
