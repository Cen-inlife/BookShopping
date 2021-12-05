package com.shoppingweb.bean;

/**
 * User 用户类
 * @version 1.0
 */
public class User implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	/**主键*/
	private int id;
	/**登录名*/
	private String loginName;
	/**密码*/
	private String password;
	/**真实姓名*/
	private String name;
	/**性别*/
	private int sex;
	/**邮件地址*/
	private String email;
	/**电话号码*/
	private String phone;
	/**家庭住址*/
	private String address;
	/**角色 （管理员和普通游客）*/
	private int role;
	/**注册时间*/
	private java.util.Date createDate;
	/**激活状态 0未激活 1已激活*/
	private String disabled;
	/**激活码*/
	private String active;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	public String getLoginName(){
		return this.loginName;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setSex(int sex){
		this.sex = sex;
	}
	public int getSex(){
		return this.sex;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setRole(int role){
		this.role = role;
	}
	public int getRole(){
		return this.role;
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
	public void setActive(String active){
		this.active = active;
	}
	public String getActive(){
		return this.active;
	}

}