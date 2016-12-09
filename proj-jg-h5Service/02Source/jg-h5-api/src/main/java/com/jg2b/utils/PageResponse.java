package com.jg2b.utils;

import java.util.List;

/**
 * 
 * 
 * @author Administrator 分页查询 不能限于 当前
 * @param <T>
 * 
 */
public class PageResponse<T> {

	private int[] pageBar;// 计算 数组 : 业务进行分页计算 封装每一次请求分页栏数据 [6,7,....15] 计算 需要
							// 总页码
	// 简化业务层封装对象代码
	private long totalCounts;// 总记录数 来自 dao 查询总记录数据 查询
	private int pageNum;// 每一次显示当前页码 业务层数据 来自 PageRequest
	private int beforePage;// 可以当前页码计算出 上一页
	private int nextPage;// pageNum+1
	private int totalPages;// 提供总页码 来自计算 : 每页记录数 + 总记录数 --->总页码
	private int pageSize; //定义一页显示多少条

	private List<T> t;// 每一次查询分页数据 由业务层 调用dao 封装

	// 分页查询的数据 来自dao 查询

	public List<T> getT() {
		return t;
	}

	public void setT(List<T> t) {
		this.t = t;
	}

	// dao 查询总记录数
	public long getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(long totalCounts) {
		this.totalCounts = totalCounts;
	}

	// PageRequest
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getBeforePage() {
		this.beforePage = this.pageNum - 1;// 考虑 当前页码 1
		if (this.beforePage <= 0) {
			this.beforePage = this.pageNum;
		}
		return this.beforePage;
	}

	// public void setBeforePage(int beforePage) {
	// this.beforePage = beforePage;
	// }

	public int getNextPage() {
		this.nextPage = this.pageNum + 1;
		if (this.nextPage >= this.totalPages) {
			this.nextPage = this.totalPages;
		}
		return this.nextPage;
	}

	// public void setNextPage(int nextPage) {
	// this.nextPage = nextPage;
	// }
	// 总页码 需要 总记录数+ 每页显示记录 共同计算
	public int getTotalPages() {
		// 举例: 100 记录 每页10 --> 10 101 11 99 10 数学公式 得出 总页码 简化if 语句判断
		this.totalPages = ((int) this.totalCounts + this.pageSize - 1)
				/ this.pageSize;
		return this.totalPages;
	}

	// public void setTotalPages(int totalPages) {
	// this.totalPages = totalPages;
	// }
	// 来自 请求PageRequest
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 每一次请求分页 页码栏 [1,2,......5]
	public int[] getPageBar() {
		// 数据 整型数据 根据当前页码 还需要总页码
		int beginPage;// 定义 分页栏起始数字
		int endPage;// 标记分页栏 结尾数字
		if (this.totalPages <= 5) {
			beginPage = 1;
			endPage = this.totalPages;
		} else {
			// 总页码 大于5 设计页码栏 前二后2
			beginPage = this.pageNum - 2;
			endPage = this.pageNum + 2;

			// 考虑 超出 ...
			if (beginPage <= 0) {
				beginPage = 1;
				endPage = beginPage + 4;
			}

			if (endPage >= this.totalPages) {
				// 20 当前页码 19
				beginPage = this.totalPages - 4;
				endPage = this.totalPages;
			}
		}

		// 最终得到 分页栏起始数字 和 结尾数字
		this.pageBar = new int[endPage - beginPage + 1];
		int index = 0;
		for (int i = beginPage; i <= endPage; i++) {
			pageBar[index++] = i;
		}
		return this.pageBar;
	}

	// public void setPageBar(int[] pageBar) {
	// this.pageBar = pageBar;
	// }

}
