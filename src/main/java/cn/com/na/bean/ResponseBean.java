package cn.com.na.bean;

import java.io.Serializable;

/**
 * 响应请求返回对象数据
 * @author David
 *
 */
public class ResponseBean implements Serializable {
	
	private static final long serialVersionUID = -1L;

	private Object data;
	private Integer retCode;
	private Object rows;
	private Object msg;
	private Long currentPageIndex = 0L;
	private Long totalPage = 0L;
	private Long totalNum = 0L;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	public Long getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(Long currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}

	
	

}
