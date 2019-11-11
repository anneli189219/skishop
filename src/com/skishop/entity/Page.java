package com.skishop.entity;

import java.util.ArrayList;

/**
 * 
 * Description: 分页实体类包括很多属性，为了Servlet调用<br />
 * ClassName: Page <br />
 * 
 * @author MPW
 * @param <T>
 */
public class Page<T> {
	private ArrayList<T> list; // 集合列表
	private int pageNum; // 当前页
	private int pageSize; // 每页显示几条数据
	private int prePageNum; // 上一页
	private int nextPageNum; // 下一页
	private int totalPageNum; // 总页数
	private int totalCount; // 数据总数

	public Page(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Page() {

	}

	public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> list) {
		this.list = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if (totalCount % pageSize == 0) {
			totalPageNum = totalCount / pageSize;
		} else {
			totalPageNum = totalCount / pageSize + 1;
		}
		if (pageNum > 1) {
			prePageNum = pageNum - 1;
		} else {
			prePageNum = 1;
		}
		if (pageNum < totalPageNum) {
			nextPageNum = pageNum + 1;
		} else {
			nextPageNum = totalPageNum;
		}
	}

}
