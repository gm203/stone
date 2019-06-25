package com.ak.common.exception.user;

/**
 * 角色锁定异常类
 * 
 * @author ak
 */
public class RoleBlockedException extends UserException {

	private static final long serialVersionUID = 3649777079579088255L;

	public RoleBlockedException() {
		super("role.blocked", null);
	}
}
