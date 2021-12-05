package com.shoppingweb_manager.service.impl;

import com.google.gson.Gson;
import com.shoppingweb.bean.Article;
import com.shoppingweb.bean.ArticleType;
import com.shoppingweb_manager.mapper.ManagerArticleMapper;
import com.shoppingweb_manager.service.ManagerArticleService;
import com.shoppingweb_manager.util.pager.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service(value="marticleService")
@Transactional
public class ManagerArticleServiceImpl implements ManagerArticleService {

    @Autowired
    private ManagerArticleMapper articleMapper;

    /*
     * 根据商品类型以及商品的标题获取商品信息
     */
    @Override
    public List<Article> getAllArticles(String typeCode, String title, PageModel pageModel) {

        //进行分页查询之前获取总记录数
        int totalNum = articleMapper.getTotalNum(typeCode,title);
        pageModel.setTotalNum(totalNum);

        return articleMapper.getAllArticles(typeCode,title,pageModel);
    }

    /*
     * 根据商品id获取商品信息
     */
    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    /*
     * 商品信息下架
     */
    @Override
    public void removeArticleById(Integer id) {
        articleMapper.removeArticleById(id);
    }

    /*
     * 保存商品信息
     */
    @Override
    public void saveArticle(Article article) {
        article.setCreateDate(new Date());
        article.setPutawayDate(new Date());
        articleMapper.saveArtice(article);
    }

    /*
     * 更新商品信息
     */
    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    //加载二级商品类型
    @Override
    public String ajaxLoadSeTypes(String code) {
        List<ArticleType> types = articleMapper.ajaxLoadSeTypes(code+"%");
        Gson gson = new Gson();
        String jsonstr = gson.toJson(types);
        return jsonstr;
    }

}
