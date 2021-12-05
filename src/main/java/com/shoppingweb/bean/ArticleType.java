package com.shoppingweb.bean;

/**
 * ArticleType 商品类型类
 * @version 1.0
 */
public class ArticleType implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/**主键 4位表示一级名称 8位表示二级名称*/
	private String code;
	/**书本类名称*/
	private String name;
	/**书本特征类描述*/
	private String remark;

	/** setter and getter method */
	public void setCode(String code){
		this.code = code;
	}
	public String getCode(){
		return this.code;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}

}