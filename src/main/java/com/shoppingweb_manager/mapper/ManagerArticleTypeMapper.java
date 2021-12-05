package com.shoppingweb_manager.mapper;

import com.shoppingweb.bean.ArticleType;
import com.shoppingweb_manager.util.pager.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ManagerArticleTypeMapper {

    /**
     * 获取所有的一级商品类型
     */
    @Select("select * from ec_article_type where length(code) = 4")
    List<ArticleType> findAllFirstArticleType();

    /**
     * @return
     */
    @Select("select count(*) from ec_article_type")
    int findTotalNum();

    /**
     * 根据商品类型以及商品的标题获取商品信息
     */
    @Select("select * from ec_article_type limit #{startNum} , #{pageSize}")
    List<ArticleType> getAllArticleTypes(PageModel pageModel);

    /**
     * 加载修改商品类型页面
     */
    @Select("select * from ec_article_type where code = #{code}")
    ArticleType getArticleTypeByCode(String code);

    /**
     * 进行更新商品类型操作
     */
    @Update("update ec_article_type set name = #{name},remark=#{remark} where code = #{code}")
    void updateArticleType(ArticleType type);

    /**
     *
     */
    @Select("SELECT MAX(CODE) FROM ec_article_type WHERE CODE LIKE #{parentCode} and length(code) = 8")
    String findMaxSeCode(String parentCode);

    /**
     * 获取最大的一级物品类型code
     */
    @Select("SELECT MAX(CODE) FROM ec_article_type WHERE  length(code) = 4")
    String findMaxFiCode();

    /**
     *
     */
    @Insert("insert into ec_article_type(code,name,remark) values(#{code},#{name},#{remark})")
    void saveArticleType(ArticleType type);

    /**
     *
     */
    @Select("SELECT * FROM ec_article_type WHERE CODE LIKE #{code} and length(code) = #{len}")
    List<ArticleType> getArticleType(@Param("code")String code, @Param("len")int len);

    /**
     *
     */
    @Delete("delete from ec_article_type where code = #{code}")
    void deleteTypes(String code);

}
