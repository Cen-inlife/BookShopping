package com.shoppingweb_manager.service.impl;

import com.shoppingweb.bean.Article;
import com.shoppingweb.bean.ArticleType;
import com.shoppingweb_manager.mapper.ManagerArticleMapper;
import com.shoppingweb_manager.mapper.ManagerArticleTypeMapper;
import com.shoppingweb_manager.service.ManagerArticleTypeService;
import com.shoppingweb_manager.util.pager.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value="marticleTypeService")
@Transactional
public class ManagerArticleTypeServiceImpl implements ManagerArticleTypeService {

    @Autowired
    private ManagerArticleTypeMapper articleTypeMapper;

    @Autowired
    private ManagerArticleMapper articleMapper;

    /*
     * 获取所有的一级商品类型
     */
    @Override
    public List<ArticleType> findAllFirstArticleType() {
        return articleTypeMapper.findAllFirstArticleType();
    }

    /*
    *根据商品类型以及商品的标题获取商品信息
 */
    @Override
    public List<ArticleType> getAllArticleTypes(PageModel pageModel) {
        int totalNum = articleTypeMapper.findTotalNum();
        pageModel.setTotalNum(totalNum);

        List<ArticleType> types = articleTypeMapper.getAllArticleTypes(pageModel);
        return types;
    }

    /*
     * 加载修改商品类型页面
     */
    @Override
    public ArticleType getArticleTypeByCode(String code) {
        return articleTypeMapper.getArticleTypeByCode(code);
    }

    /*
     * 进行更新商品类型操作
     */
    @Override
    public void updateArticleType(ArticleType type) {
        articleTypeMapper.updateArticleType(type);
    }

    /*
     *  进行添加商品类型操作
     */
    @Override
    public void saveArticleType(ArticleType type, String parentCode) {
        StringBuffer code = new StringBuffer();

        if(parentCode != null && !parentCode.equals("")) {
            String maxCode = articleTypeMapper.findMaxSeCode(parentCode+"%");

            if(maxCode == null || maxCode.equals("")) {
                //00010001
                code.append(parentCode).append("0001");
            }else {
                //maxCode:00010009   ==  >00010010
                code.append(parentCode);
                Integer code2 = Integer.parseInt(maxCode.substring(4)) + 1;

                for(int i=0;i<4 - String.valueOf(code2).length() ; i++) {
                    code.append("0");
                }
                code.append(code2);

            }

        }else {
            //获取最大的一级物品类型code
            String maxFirstCode = articleTypeMapper.findMaxFiCode();


            Integer code2 = Integer.parseInt(maxFirstCode) + 1;

            for(int i=0;i<4 - String.valueOf(code2).length() ; i++) {
                code.append("0");
            }
            code.append(code2);

        }

        //指定当前商品类型的code
        type.setCode(code.toString());
        articleTypeMapper.saveArticleType(type);

    }

    /*
     * 删除商品类型
     */
    @Override
    public String deleteType(String code) {
        //根据code获取是否存在下级商品类型信息
        List<ArticleType> types = articleTypeMapper.getArticleType(code+"%",code.length()+4);
        //判断商品类型下是否有商品关联到该商品类型
        List<Article> articles = articleMapper.getArticleByType(code);
        if(types.size() > 0 || articles.size() > 0) {

            return "删除失败，该商品类型下存在下级商品类型,或存在关联的商品信息！";
        }else {
            articleTypeMapper.deleteTypes(code);
            return "删除成功！";
        }
    }

}
