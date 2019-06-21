package com.ak.framework.datasource;

import java.util.Map;

import com.ak.common.exception.BusinessException;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DataSourceBeanBuilder {
	private static final String URL_FORMATTER = "%s%s:%s%s%s";
	private final String beanName;// Bean统一交给Spring管理，所以beanName必须唯一
	private final String databaseIp;
	private final String databasePort;
	private final String driverClassName;
	private final String databaseName;
	private final String username;
	private final String password;
	private String validationQuery = "select 1 from dual";
	private boolean testOnBorrow = true;

	public DataSourceBeanBuilder(Map<String, String> dataSource) {
		this.beanName = dataSource.get("datasource_name");// 唯一、主键
		this.databaseIp = dataSource.get("database_ip");
		this.databasePort = dataSource.get("database_port");
		this.driverClassName = dataSource.get("database_driver_class_name");
		this.databaseName = dataSource.get("database_name");
		this.username = dataSource.get("database_username");
		this.password = dataSource.get("database_password");
	}

	public DataSourceBeanBuilder validationQuery(String value) {
		this.validationQuery = value;
		return this;
	}

	public DataSourceBeanBuilder testOnBorrow(boolean value) {
		this.testOnBorrow = value;
		return this;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public String getUrl() {
		if (driverClassName.contains("oracle")) {
			String url = String.format(URL_FORMATTER, "jdbc:oracle:thin:@", this.databaseIp, this.databasePort, ":",
					this.databaseName);
			log.info(url);
			return url;
		} else if (driverClassName.contains("mysql")) {
			String url = String.format(URL_FORMATTER, "jdbc:mysql://", this.databaseIp, this.databasePort, "/",
					this.databaseName)
					+ "?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true";
			log.info(url);
			return url;
		} else {
			throw new BusinessException("暂时只支持Oracle和MySQL数据库链接");
		}
	}

	public String getBeanName() {
		return beanName;
	}

	@Override
	public String toString() {
		return "DataSourceBeanBuilder{" + "driverClassName='" + driverClassName + '\'' + ", databaseIp='" + databaseIp
				+ '\'' + ", databasePort='" + databasePort + '\'' + ", databaseName='" + databaseName + '\''
				+ ", username='" + username + '\'' + ", password='" + password + '\'' + ", validationQuery='"
				+ validationQuery + '\'' + ", testOnBorrow=" + testOnBorrow + '}';
	}
}