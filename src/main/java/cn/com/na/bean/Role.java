package cn.com.na.bean;

import java.io.Serializable;

/**
 * 角色实体
 * @author David
 * TABLE role
 */
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int roleId; //角色ID
	private int roleType;//角色类型
	private String description;//角色描述
	private String note;//备注
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getRoleType() {
		return roleType;
	}
	public void setRoleType(int roleType) {
		this.roleType = roleType;
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
		return "Role [roleId=" + roleId + ", roleType=" + roleType
				+ ", description=" + description + ", note=" + note + "]";
	}
	
	
	
	
}
