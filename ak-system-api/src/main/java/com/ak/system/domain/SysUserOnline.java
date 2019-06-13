package com.ak.system.domain;

import java.util.Date;

import com.ak.common.core.domain.BaseEntity;
import com.ak.common.enums.OnlineStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * 当前在线会话 sys_user_online
 * 
 * @author ak
 */
@Getter
@Setter
public class SysUserOnline extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 用户会话id */
	private String sessionId;

	/** 部门名称 */
	private String deptName;

	/** 登录名称 */
	private String loginName;

	/** 登录IP地址 */
	private String ipaddr;

	/** 登录地址 */
	private String loginLocation;

	/** 浏览器类型 */
	private String browser;

	/** 操作系统 */
	private String os;

	/** session创建时间 */
	private Date startTimestamp;

	/** session最后访问时间 */
	private Date lastAccessTime;

	/** 超时时间，单位为分钟 */
	private Long expireTime;

	/** 在线状态 */
	private OnlineStatus status = OnlineStatus.on_line;

}
