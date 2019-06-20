package com.ak.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ak.demo.domain.DataSource;

@Mapper
public interface DataSourceMapper {

	@Select({ "select datasource_name,database_ip,database_port,database_name,database_username,"
			+ "database_password,gmt_create,gmt_modified FROM other_datasource_meta" })
	List<DataSource> getAllDataSources();

	@Select({ "select datasource_name,database_ip,database_port,database_name,database_username,"
			+ "database_password,gmt_create,gmt_modified FROM other_datasource_meta WHERE datasource_name = #{datasourceName}" })
	Map<String, String> queryByDatasourceName(String datasourceName);
	
	@Select({ "select datasource_name,database_ip,database_port,database_name,database_username,"
			+ "database_password,gmt_create,gmt_modified FROM other_datasource_meta WHERE datasource_name = #{datasourceName}" })
	Map<String, String> queryDatasource(String datasourceName);
}
