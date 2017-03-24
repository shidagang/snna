package cn.com.na.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登陆表
 * @author David
 * Table: t_user
 * t_user--- role(1:1) 
 */
public class TUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private Integer userId; //用户ID主键，自增
	 private String account;//用户名
	 private String password;//用户密码
	 private int roleId;//角色ID
	 private String note;//备注
	 private int activate; //是否激活:1是;0否
	 private Date createTime;//创建时间
	 
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", account=" + account
				+ ", password=" + password + ", roleId=" + roleId + ", note="
				+ note + "]";
	}
	public int getActivate() {
		return activate;
	}
	public void setActivate(int activate) {
		this.activate = activate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
	

}
