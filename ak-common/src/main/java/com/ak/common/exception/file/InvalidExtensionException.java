package com.ak.common.exception.file;

import java.util.Arrays;
import org.apache.commons.fileupload.FileUploadException;

/**
 * 文件上传 误异常类
 * 
 * @author ak
 */
public class InvalidExtensionException extends FileUploadException {

	private static final long serialVersionUID = 6352843174705638545L;
	private String[] allowedExtension;
	private String extension;
	private String filename;

	public InvalidExtensionException(String[] allowedExtension, String extension, String filename) {
		super("filename : [" + filename + "], extension : [" + extension + "], allowed extension : ["
				+ Arrays.toString(allowedExtension) + "]");
		this.allowedExtension = allowedExtension;
		this.extension = extension;
		this.filename = filename;
	}

	public String[] getAllowedExtension() {
		return allowedExtension;
	}

	public String getExtension() {
		return extension;
	}

	public String getFilename() {
		return filename;
	}

	public static class InvalidImageExtensionException extends InvalidExtensionException {

		private static final long serialVersionUID = 7978818331520454622L;

		public InvalidImageExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidFlashExtensionException extends InvalidExtensionException {

		private static final long serialVersionUID = -7924982088337151184L;

		public InvalidFlashExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidMediaExtensionException extends InvalidExtensionException {

		private static final long serialVersionUID = 1754377059000667882L;

		public InvalidMediaExtensionException(String[] allowedExtension, String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}
}
