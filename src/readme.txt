shoppingweb包下的controller :
    ArticleController:
                        index.jsp中重定向到的就是这个controller里面的articleIndex  ==> 指向articleIndex.jsp页面 （商品首页）
                        articleIndex 处理的是获取一级物品类型 在根据一级物品类型获取二级物品类型
                        而且处理用户自行选择商品类型，然后查询数据库来返回该类型下的商品
                        用户还可以点击商品来查看商品详情 ==> articleDetail.jsp(商品详情页)
