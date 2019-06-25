package com.ak.common.config;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import com.ak.common.utils.StringUtils;
import com.ak.common.utils.YamlUtil;

import lombok.extern.log4j.Log4j2;

/**
 * 全局配置类
 * 
 * @author ak
 */
@Log4j2
public class Global {

	private static String NAME = "application.yml";

	/**
	 * 当前对象实例
	 */
	private static Global global;

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String, String>();

	private Global() {
	}

	/**
	 * 静态工厂方法
	 */
	public static synchronized Global getInstance() {
		if (global == null) {
			global = new Global();
		}
		return global;
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			Map<?, ?> yamlMap = null;
			try {
				yamlMap = YamlUtil.loadYaml(NAME);
				value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
				map.put(key, value != null ? value : StringUtils.EMPTY);
			} catch (FileNotFoundException e) {
				log.error("获取全局配置异常 {}", key);
			}
		}
		return value;
	}

	/**
	 * 获取项目名称
	 */
	public static String getName() {
		return StringUtils.nvl(getConfig("ak.name"), "ak");
	}

	/**
	 * 获取项目版本
	 */
	public static String getVersion() {
		return StringUtils.nvl(getConfig("ak.version"), "1.1.0");
	}

	/**
	 * 获取版权年份
	 */
	public static String getCopyrightYear() {
		return StringUtils.nvl(getConfig("ak.copyrightYear"), "2019");
	}

	/**
	 * 实例演示开关
	 */
	public static String isDemoEnabled() {
		return StringUtils.nvl(getConfig("ak.demoEnabled"), "true");
	}

	/**
	 * 获取ip地址开关
	 */
	public static Boolean isAddressEnabled() {
		return Boolean.valueOf(getConfig("ak.addressEnabled"));
	}

	/**
	 * 获取文件上传路径
	 */
	public static String getProfile() {
		return getConfig("ak.profile");
	}

	/**
	 * 获取头像上传路径
	 */
	public static String getAvatarPath() {
		return getConfig("ak.profile") + "avatar/";
	}

	/**
	 * 获取下载路径
	 */
	public static String getDownloadPath() {
		return getConfig("ak.profile") + "download/";
	}

	/**
	 * 获取上传路径
	 */
	public static String getUploadPath() {
		return getConfig("ak.profile") + "upload/";
	}
}
