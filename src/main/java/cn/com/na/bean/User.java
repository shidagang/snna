package cn.com.na.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户实体类
 * @author David
 *
 */
public class User implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userId; // userId 自增长
	private String account; // 用户名
	private String password;// 密码
	private String nickName;// 昵称
	private String sex;		// 性别
	private String img;		// 头像
	private String url;		// 域名
	private String mphone; //移动电话号码
	private String tPhone; //固定电话
	private String email; //邮箱
	private String address; //地址
	private String reTimedate; //注册日期
	private int roleId; // 角色ID
	private String note; // 备注
	private String channelType; // 渠道类型：0:PC, 1:amdroid, 2:IO
	private Integer activate; //是否激活:1是;0否
	private Date createTime;//创建时间
	
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String gettPhone() {
		return tPhone;
	}
	public void settPhone(String tPhone) {
		this.tPhone = tPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReTimedate() {
		return reTimedate;
	}
	public void setReTimedate(String reTimedate) {
		this.reTimedate = reTimedate;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	 
	public Integer getActivate() {
		return activate;
	}
	public void setActivate(Integer activate) {
		this.activate = activate;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account
				+ ", password=" + password + ", nickName=" + nickName
				+ ", sex=" + sex + ", img=" + img + ", url=" + url
				+ ", mphone=" + mphone + ", tPhone=" + tPhone + ", email="
				+ email + ", address=" + address + ", reTimedate=" + reTimedate
				+ ", roleId=" + roleId + ", note=" + note + ", channelType="
				+ channelType + ", activate=" + activate + ", createTime="
				+ createTime + "]";
	}
	
}
