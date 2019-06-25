package com.ak.common.exception.user;

import com.ak.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author ak
 */
public class UserException extends BaseException {

	private static final long serialVersionUID = 2539515660324822406L;

	public UserException(String code, Object[] args) {
		super("user", code, args, null);
	}
}
