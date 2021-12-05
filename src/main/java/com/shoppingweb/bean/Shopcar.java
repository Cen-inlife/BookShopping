package com.shoppingweb.bean;

/**
 * Shopcar 购物车类
 * @version 1.0
 */
public class Shopcar implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/**购买数量*/
	private int buynum;
	/**主键 （外键 所属用户）*/
	private int userId;
	/**主键 （外键 所购商品）*/
	private int articleId;
	
	private Article article;

	/** setter and getter method */
	public void setBuynum(int buynum){
		this.buynum = buynum;
	}
	public int getBuynum(){
		return this.buynum;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}
	public int getArticleId(){
		return this.articleId;
	}
	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}
	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}
	
	

}