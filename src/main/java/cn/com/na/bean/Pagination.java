package cn.com.na.bean;

import java.io.Serializable;

/**
 * 查询条件返回对象
 * @author LIUYONG
 * 2016-12-20
 */
public class Pagination implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8112725782522863224L;
	/** 当前页码 */
	private Long currentPageIndex = 1L;
	/** 每页显示记录数量 */
	private Long pageSize = 20L;
	/** 开始记录位置  */
	private Long firstRecordIndex = null;
	/** 总记录数  */
	private int totalNum;
	/** 总页数  */
	private int totalPage;
	
	
	
	/**
	 * 获取当前页码
	 * @return currentPageIndex 当前页码
	 */
	public Long getCurrentPageIndex() {
		return currentPageIndex;
	}
	/**
	 * 设置当前页码
	 * @param currentPageIndex 当前页码
	 */
	public void setCurrentPageIndex(Long currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	/**
	 * 获取每页显示记录数量
	 * @return eachPageSize 每页显示记录数量
	 */
	public Long getPageSize() {
		return pageSize;
	}
	/**
	 * 设置每页显示记录数量
	 * @param eachPageSize 每页显示记录数量
	 */
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 获取开始记录位置
	 * @return firstRecordIndex 开始记录位置
	 */
	public Long getFirstRecordIndex() {
		if(null == this.currentPageIndex || null == this.pageSize){
			return null;
		}
		Long ct = (this.currentPageIndex - 1) * this.pageSize;
		return ct < 0 ? 0 : ct;
	}

	/**
	 * 设置开始记录位置
	 * @param firstRecordIndex 开始记录位置
	 */
	public void setFirstRecordIndex(Long firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	/**
	 * 获得总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * 设置总页数
	 */
	public void setTotalPage() {
		if (totalNum > 0 && pageSize > 0) {
			Long page = totalNum / pageSize;
			if (totalNum % pageSize > 0) {
				totalPage = page.intValue() + 1;
			} else {
				totalPage = page.intValue();
			}
		}
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		setTotalPage();
	}
	
	
	
}
