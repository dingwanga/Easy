package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {

	// 总页数
	private int totalPageCount;
	// 页面大小，即每页显示记录数默认为3
	private int pageSize;
	// 总记录数
	private int totalCount;
	// 当前页码
	private int currPageNo;
	// 每页信息集合
	private List<T> pageList;

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			totalPageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize)
					: (totalCount / pageSize + 1);
		}
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if (currPageNo <= 1) {
			this.currPageNo = 1;
		} else if (currPageNo > totalPageCount) {
			this.currPageNo = totalPageCount;
		} else {
			this.currPageNo = currPageNo;
		}
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}
