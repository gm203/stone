package com.ak.common.exception.file;

/**
 * 文件名大小限制异常类
 * 
 * @author ak
 */
public class FileSizeLimitExceededException extends FileException {

	private static final long serialVersionUID = -5695865640987377134L;

	public FileSizeLimitExceededException(long defaultMaxSize) {
		super("upload.exceed.maxSize", new Object[] { defaultMaxSize });
	}
}
