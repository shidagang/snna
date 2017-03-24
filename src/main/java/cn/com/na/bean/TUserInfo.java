package cn.com.na.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户网络信息实体
 * @author David
 * Table：t_userinfo
 */
public class TUserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private int Id; //自增ID
	 private int userId;//用户ID
	 private String nickName;//昵称
	 private String sex;//性别： 1：男 0 女
	 private String img;//用户头像存放路径
	 private String url;//域名URL
	 private String mPhone;//移动电话号码
	 private String tPhone;//固定电话
	 private String eMail;//邮箱
	 private String address;//地址
	 private Date reTIme;//注册日期
	 private String note;//备注
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String gettPhone() {
		return tPhone;
	}
	public void settPhone(String tPhone) {
		this.tPhone = tPhone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getReTIme() {
		return reTIme;
	}
	public void setReTIme(Date reTIme) {
		this.reTIme = reTIme;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "T_UserInfo [Id=" + Id + ", userId=" + userId + ", nickName="
				+ nickName + ", sex=" + sex + ", img=" + img + ", url=" + url
				+ ", mPhone=" + mPhone + ", tPhone=" + tPhone + ", eMail="
				+ eMail + ", address=" + address + ", reTIme=" + reTIme
				+ ", note=" + note + "]";
	}
	 
	 
	 
	

}
