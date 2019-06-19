package com.ak.common.core.page;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 表格分页数据对象
 * 
 * @author ak
 */
public class TableDataInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 总记录数 */
	@Getter
	@Setter
	private long total;
	
	/** 列表数据 */
	@Getter
	@Setter
	private List<?> rows;
	
	/** 消息状态码 */
	@Getter
	@Setter
	private int code;

	/**
	 * 表格数据对象
	 */
	public TableDataInfo() {}

	/**
	 * 分页
	 * 
	 * @param list  列表数据
	 * @param total 总记录数
	 */
	public TableDataInfo(List<?> list, int total) {
		this.rows = list;
		this.total = total;
	}
}
