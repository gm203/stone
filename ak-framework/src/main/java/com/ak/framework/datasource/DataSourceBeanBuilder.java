package com.ak.framework.datasource;

import java.util.Map;

public class DataSourceBeanBuilder {
	private static final String URL_FORMATTER = "jdbc:mysql://%s:%s/%s?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true";
	private String driverClassName;
	private final String beanName;// Bean统一交给Spring管理，所以beanName必须唯一
	private final String databaseIp;
	private final String databasePort;
	private final String databaseName;
	private final String username;
	private final String password;
	private String validationQuery = "select 1";
	private boolean testOnBorrow = true;

	public DataSourceBeanBuilder(Map<String, String> dataSource) {
		this.beanName = dataSource.get("datasource_name");
		this.databaseIp = dataSource.get("database_ip");
		this.databasePort = dataSource.get("database_port");
		this.databaseName = dataSource.get("database_name");
		this.username = dataSource.get("database_username");
		this.password = dataSource.get("database_password");
	}

	public DataSourceBeanBuilder driverClassName(String value) {
		this.driverClassName = value;
		return this;
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
		return String.format(URL_FORMATTER, this.databaseIp, this.databasePort, this.databaseName);
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