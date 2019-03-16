package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {

	// ��ҳ��
	private int totalPageCount;
	// ҳ���С����ÿҳ��ʾ��¼��Ĭ��Ϊ3
	private int pageSize;
	// �ܼ�¼��
	private int totalCount;
	// ��ǰҳ��
	private int currPageNo;
	// ÿҳ��Ϣ����
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
