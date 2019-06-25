package com.ak.common.exception.user;

/**
 * 用户错误记数异常类
 * 
 * @author ak
 */
public class UserPasswordRetryLimitCountException extends UserException {

	private static final long serialVersionUID = -1005219558439729136L;

	public UserPasswordRetryLimitCountException(int retryLimitCount) {
		super("user.password.retry.limit.count", new Object[] { retryLimitCount });
	}
}
