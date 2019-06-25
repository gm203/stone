package com.ak.common.exception.user;

/**
 * 用户账号已被删除
 * 
 * @author ak
 */
public class UserDeleteException extends UserException {

	private static final long serialVersionUID = -2235886273602872824L;

	public UserDeleteException() {
		super("user.password.delete", null);
	}
}
