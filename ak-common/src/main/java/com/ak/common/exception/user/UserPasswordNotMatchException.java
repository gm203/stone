package com.ak.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 * 
 * @author ak
 */
public class UserPasswordNotMatchException extends UserException {

	private static final long serialVersionUID = 3468552332933489632L;

	public UserPasswordNotMatchException() {
		super("user.password.not.match", null);
	}
}
