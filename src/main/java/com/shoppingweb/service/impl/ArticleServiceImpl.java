package com.shoppingweb.service.impl;

import com.shoppingweb.bean.Article;
import com.shoppingweb.bean.ArticleType;
import com.shoppingweb.mapper.ArticleMapper;
import com.shoppingweb.mapper.ArticleTypeMapper;
import com.shoppingweb.service.ArticleService;
import com.shoppingweb.util.pager.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /*
     *获取所有的一级物品类型
     */
    @Override
    public List<ArticleType> findAllFirstArticleType() {
        // TODO Auto-generated method stub
        List<ArticleType> articleTypes = articleTypeMapper.findAllFirstArticleType();
        return articleTypes;
    }

    /*
     * 根据商品类型获取商品信息
     */
    @Override
    public List<Article> findAllArticle(String typeCode, String keyword, PageModel pageModel) {
        // TODO Auto-generated method stub
        List<Article> articles = articleMapper.findAllArticle(typeCode,keyword,pageModel);
        return articles;
    }

    /*
     * 根据一级物品类型获取对应的二级物品类型信息
     */
    @Override
    public List<ArticleType> findAllSecondArticleTypes(String typeCode) {
        // TODO Auto-generated method stub
        List<ArticleType>  articleTypes = articleTypeMapper.findAllSecondArticleTypes(typeCode);
        return articleTypes;
    }

    /*
     * 根据商品id获取商品详情信息
     */
    @Override
    public Article getArticleById(Integer id) {
        // TODO Auto-generated method stub
        //根据商品id获取商品详情信息
        Article article = articleMapper.getArticleById(id);
        return article;
    }

    /*
     * 查询总记录数
     */
    @Override
    public int findTotalNum(String typeCode, String keyword) {
        return articleMapper.findTotalNum(typeCode,keyword);
    }


}
