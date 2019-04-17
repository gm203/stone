package com.ak.generator.domain;

import com.ak.common.json.JSON;
import com.ak.common.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * ry数据库表列信息
 * 
 * @author ak
 */
public class ColumnInfo {
	/** 字段名称 */
	@Getter
	@Setter
	private String columnName;

	/** 字段类型 */
	@Getter
	@Setter
	private String dataType;

	/** 列描述 */
	private String columnComment;

	/** 列配置 */
	private ColumnConfigInfo configInfo;

	/** Java属性类型 */
	@Getter
	@Setter
	private String attrType;

	/** Java属性名称(第一个字母大写)，如：user_name => UserName */
	private String attrName;

	/** Java属性名称(第一个字母小写)，如：user_name => userName */
	private String attrname;

	/** 执行计划（包含了与索引相关的一些细节信息） */
	@Getter
	@Setter
	private String extra;

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) throws Exception {
		// 根据列描述解析列的配置信息
		if (StringUtils.isNotEmpty(columnComment) && columnComment.startsWith("{")) {
			this.configInfo = JSON.unmarshal(columnComment, ColumnConfigInfo.class);
			this.columnComment = configInfo.getTitle();
		} else {
			this.columnComment = columnComment;
		}
	}
	
	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}
}
