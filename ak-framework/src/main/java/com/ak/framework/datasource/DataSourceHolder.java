package com.ak.framework.datasource;

public final class DataSourceHolder {
	private static final ThreadLocal<DataSourceBeanBuilder> threadLocal = new ThreadLocal<DataSourceBeanBuilder>();

	static DataSourceBeanBuilder getDataSource() {
		return threadLocal.get();
	}

	// 使用该方法设置数据源
	public static void setDataSource(DataSourceBeanBuilder dataSourceBeanBuilder) {
		threadLocal.set(dataSourceBeanBuilder);
	}

	// 使用该方法清除数据源，清除后将使用默认数据源
	public static void clearDataSource() {
		threadLocal.remove();
	}
}
