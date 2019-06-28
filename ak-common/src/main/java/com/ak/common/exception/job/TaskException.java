package com.ak.common.exception.job;

/**
 * 计划策略异常
 * 
 * @author ak
 */
public class TaskException extends Exception {

	private static final long serialVersionUID = 8702701806151614488L;
	private Code code;

	public TaskException(String msg, Code code) {
		this(msg, code, null);
	}

	public TaskException(String msg, Code code, Exception nestedEx) {
		super(msg, nestedEx);
		this.code = code;
	}

	public Code getCode() {
		return code;
	}
	
	/**
	 * 异常枚举
	 * @author dvean
	 * @date 2019/06/26
	 */
	public enum Code {
		TASK_EXISTS, NO_TASK_EXISTS, TASK_ALREADY_STARTED, UNKNOWN, CONFIG_ERROR, TASK_NODE_NOT_AVAILABLE
	}
}