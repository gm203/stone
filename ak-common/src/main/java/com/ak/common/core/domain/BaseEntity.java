package com.ak.common.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity基类
 * 
 * @author ak
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 搜索值 */
	@Getter
	@Setter
	private String searchValue;

	/** 创建者 */
	@Getter
	@Setter
	private String createBy;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Getter
	@Setter
	private Date createTime;

	/** 更新者 */
	@Getter
	@Setter
	private String updateBy;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Getter
	@Setter
	private Date updateTime;

	/** 备注 */
	@Getter
	@Setter
	private String remark;
	
	/** 删除标志（0代表存在 2代表删除） */
	@Getter
	@Setter
	private String delFlag;

	/** 请求参数 */
	private Map<String, Object> params;

	public Map<String, Object> getParams() {
		if (params == null) {
			params = new HashMap<>();
		}
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
