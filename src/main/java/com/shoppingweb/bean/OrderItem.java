package com.shoppingweb.bean;

/**
 * OrderItem 订单明细类
 * @version 1.0
 */
public class OrderItem implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/**主键 (外键 订单编号)*/
	private int orderId;
	/**主键 （外键 所购商品）*/
	private int articleId;
	/**所购商品的数量*/
	private int orderNum;
	
	private Article article;

	/** setter and getter method */
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	public int getOrderId(){
		return this.orderId;
	}
	public void setArticleId(int articleId){
		this.articleId = articleId;
	}
	public int getArticleId(){
		return this.articleId;
	}
	public void setOrderNum(int orderNum){
		this.orderNum = orderNum;
	}
	public int getOrderNum(){
		return this.orderNum;
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