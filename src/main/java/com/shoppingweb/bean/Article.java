package com.shoppingweb.bean;

/**
 * Article 商品类
 * 对应ec_article 外键是typeCode
 * @version 1.0
 */
public class Article implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/**主键*/
	private int id;
	/**商品标题*/
	private String title;
	/**供应商*/
	private String supplier;
	/**价格*/
	private double price;
	/**折扣*/
	private double discount;
	/**出版社*/
	private String locality;
	/**上架时间*/
	private java.util.Date putawayDate;
	/**库存*/
	private int storage;
	/**书本封面*/
	private String image;
	/**描述分类*/
	private String description;
	/**类型（外键）*/
	private String typeCode;
	/**创建时间*/
	private java.util.Date createDate;
	/**无货？*/
	private String disabled;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setSupplier(String supplier){
		this.supplier = supplier;
	}
	public String getSupplier(){
		return this.supplier;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public double getPrice(){
		return this.price;
	}
	public void setDiscount(double discount){
		this.discount = discount;
	}
	public double getDiscount(){
		return this.discount;
	}
	public void setLocality(String locality){
		this.locality = locality;
	}
	public String getLocality(){
		return this.locality;
	}
	public void setPutawayDate(java.util.Date putawayDate){
		this.putawayDate = putawayDate;
	}
	public java.util.Date getPutawayDate(){
		return this.putawayDate;
	}
	public void setStorage(int storage){
		this.storage = storage;
	}
	public int getStorage(){
		return this.storage;
	}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return this.image;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setTypeCode(String typeCode){
		this.typeCode = typeCode;
	}
	public String getTypeCode(){
		return this.typeCode;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setDisabled(String disabled){
		this.disabled = disabled;
	}
	public String getDisabled(){
		return this.disabled;
	}
	
	//计算折扣价
	public double getDiscountPrice() {
		return this.getPrice() * this.getDiscount();
	}

}