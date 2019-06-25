package com.ak.oa.domain;

import com.ak.common.annotation.Excel;
import com.ak.common.core.domain.BaseEntity;
import com.ak.system.domain.SysUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calendar extends BaseEntity {

	private static final long serialVersionUID = -222239229355504392L;
	
	@Excel(name = "事件标题")
	private String title; // 事件标题
	@Excel(name = "事件开始时间")
	private String start; // 事件开始时间
	@Excel(name = "事件结束时间")
	private String end; // 事件结束时间
	@Excel(name = "是否为全天时间")
	private String adllDay; // 是否为全天时间
	@Excel(name = "时间的背景色")
	private String color; // 时间的背景色
	@Excel(name = "所属用户")
	private SysUser user; // 所属用户
	
}
