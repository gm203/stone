package com.ak.common.exception.user;

/**
 * 用户错误最大次数异常类
 * 
 * @author ak
 */
public class UserPasswordRetryLimitExceedException extends UserException {

	private static final long serialVersionUID = 349380511127515560L;

	public UserPasswordRetryLimitExceedException(int retryLimitCount) {
		super("user.password.retry.limit.exceed", new Object[] { retryLimitCount });
	}
}
