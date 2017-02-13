package com.ht.common.bean;

import java.util.List;

/**
 * EasyUI�ķ�ҳ��
 * @author Administrator
 *
 * @param <T>
 */
public class Pager4EasyUI<T> {

	private int pageSize; // ҳ��Ĵ�С
	private int pageNo; // �ڼ�ҳ
	
	private long total; // ҳ�����ҳ��
	private List<T> rows; // ���ص�ҳ��Ľ��
	
	public int getBeginIndex() {
		return (pageNo - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
