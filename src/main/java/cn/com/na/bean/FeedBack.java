package cn.com.na.bean;

import java.io.Serializable;

/**
 * 改进问题表
 * @author David
 *
 * TABLE： feedback
 * 
 */
public class FeedBack implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int fid; //ID自增
	private int userId; //用户ID
	private String title; //问题标题
	private String content; //问题内容
	private String note;//备注
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "FeedBack [fid=" + fid + ", userId=" + userId + ", title="
				+ title + ", content=" + content + ", note=" + note + "]";
	}
	
	
	
	
	
}
