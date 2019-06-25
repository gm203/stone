package com.ak.common.exception.user;

/**
 * 用户锁定异常类
 * 
 * @author ak
 */
public class UserBlockedException extends UserException {

	private static final long serialVersionUID = 7824059407929900268L;

	public UserBlockedException() {
		super("user.blocked", null);
	}
}
