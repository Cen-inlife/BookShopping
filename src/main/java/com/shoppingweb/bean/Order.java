package com.shoppingweb.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Order 订单类
 * @version 1.0
 */
public class Order implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/**主键*/
	private int id;
	/**订单号*/
	private String orderCode;
	/**订单创建时间*/
	private java.util.Date createDate;
	/**订单发货时间*/
	private java.util.Date sendDate;
	/**订单状态*/
	private String status;
	/**金额*/
	private double amount;
	/**订单所属的用户*/
	private int userId;
	//保存微信二维码图片（不存在于数据库字段中）
	private String imgUrl;
	
	//支付状态    0未支付    1已支付
	private String payStatus;
	
	//定义集合用于封装订单详情信息
	private List<OrderItem> items = new ArrayList<>();

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setOrderCode(String orderCode){
		this.orderCode = orderCode;
	}
	public String getOrderCode(){
		return this.orderCode;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public void setSendDate(java.util.Date sendDate){
		this.sendDate = sendDate;
	}
	public java.util.Date getSendDate(){
		return this.sendDate;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	public double getAmount(){
		return this.amount;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return this.userId;
	}
	/**
	 * @return the items
	 */
	public List<OrderItem> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
  
	
}