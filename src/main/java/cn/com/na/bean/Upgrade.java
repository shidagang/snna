package cn.com.na.bean;

import java.io.Serializable;

/**
 * App 更新实体
 * @author David
 * table： upgrade
 */
public class Upgrade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int uId;//ID自增
	private int versionCode;//当前APP版本
	private String versionName;//app版本名称
	private String filePath;//APP下载路径
	private String description;//描述
	private String note;//备注
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Upgrade [uId=" + uId + ", versionCode=" + versionCode
				+ ", versionName=" + versionName + ", filePath=" + filePath
				+ ", description=" + description + ", note=" + note + "]";
	}

}
