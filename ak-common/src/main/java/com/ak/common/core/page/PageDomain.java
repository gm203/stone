package com.ak.common.core.page;

import com.ak.common.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页数据
 * 
 * @author ak
 */
public class PageDomain {
	
	/** 当前记录起始索引 */
	@Getter
	@Setter
	private Integer pageNum;
	
	/** 每页显示记录数 */
	@Getter
	@Setter
	private Integer pageSize;
	
	/** 排序列 */
	@Getter
	@Setter
	private String orderByColumn;
	
	/** 排序的方向 "desc" 或者 "asc". */
	@Getter
	@Setter
	private String isAsc;

	public String getOrderBy() {
		if (StringUtils.isEmpty(orderByColumn)) {
			return "";
		}
		return StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
	}

}
