package cn.com.na.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
		
/**   
 * API返回查询对象
 *@author liuyong
 */
public class QueryResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4039523069433049730L;
	/** 返回结果集 */
	private List result;
	/** 当前页码 */
	private Long currentPageIndex;
	/** 每页显示记录数量 */
	private Long pageSize;
	/** 记录总数 */
	private Long totalNum;
	/** 一共有多少页 */
	private Long totalPage;
	
	/**
	 * 
	 */
	public QueryResult() {
		super();
	}
	
	/**
	 * 构造函数
	 * @param result 返回结果集
	 */
	public QueryResult(List result) {
		super();
		this.result = result;
	}


	
	/**
	 * 获取返回结果集
	 * @return result 返回结果集
	 */
	public List getResult() {
		return result;
	}

	/**
	 * 设置返回结果集
	 * @param result 返回结果集
	 */
	public void setResult(List result) {
		this.result = result;
	}



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
	 * @return recordSize 每页显示记录数量
	 */
	public Long getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页显示记录数量
	 * @param recordSize 每页显示记录数量
	 */
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取一共有多少页
	 * @return totalPage 一共有多少页
	 */
	public Long getTotalPage() {
		return totalPage;
	}

	/**
	 * 设置一共有多少页
	 * @param totalPage 一共有多少页
	 */
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获取记录总数
	 * @return recoredCount 记录总数
	 */
	public Long getTotalNum() {
		return totalNum;
	}

	/**
	 * 设置记录总数
	 * @param recoredCount 记录总数
	 */
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}
	
}

	