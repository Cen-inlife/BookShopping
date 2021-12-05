package com.shoppingweb.controller;

import com.shoppingweb.bean.Article;
import com.shoppingweb.bean.ArticleType;
import com.shoppingweb.service.ArticleService;
import com.shoppingweb.util.pager.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/index")
    public String  articleIndex(Model model, String typeCode, String keyword, PageModel pageModel) {

        //获取所有的一级物品类型
        List<ArticleType> articleTypes = articleService.findAllFirstArticleType();
        model.addAttribute("articleTypes", articleTypes);
        model.addAttribute("typeCode", typeCode);
        model.addAttribute("keyword", keyword);
        System.out.println("typeCode:"+typeCode);
        //如果 typecode不为空，则根据typeCode查询二级物品类型
        if(typeCode != null && !typeCode.equals("")) {

            // 0001 ==> 0001     00010001 ==> 0001
            String code = typeCode.substring(0, 4);

            //根据一级物品类型获取对应的二级物品类型信息
            List<ArticleType> seArticleTypes = articleService.findAllSecondArticleTypes(code+"%");
            //将二级物品类型存放至 model
            model.addAttribute("secondArticleTypes", seArticleTypes);
        }

        //根据 用户指定的商品类型查询数据库，获取相应的商品信息
        List<Article> articles = articleService.findAllArticle(typeCode == null ? null : typeCode+"%",keyword == null ? null : "%"+keyword+"%",pageModel);
        model.addAttribute("articles", articles);

        //查询总记录数
        int totalNum = articleService.findTotalNum(typeCode == null ? null : typeCode+"%",keyword == null ? null : "%"+keyword+"%");
        pageModel.setTotalNum(totalNum);


        // WEB-INF/jsp/articleIndex.jsp
        return "articleIndex";
    }

    //根据商品id获取商品详情信息
    @RequestMapping("/detail")
    public String articleDetail(Integer id,Model model) {
        //根据商品id获取商品信息
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);

        // /WEB-INF/jsp/articleDetail.jsp
        return "articleDetail";
    }

}
