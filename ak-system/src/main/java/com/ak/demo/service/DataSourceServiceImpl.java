package com.ak.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.common.exception.BusinessException;
import com.ak.demo.domain.User;
import com.ak.demo.mapper.DataSourceMapper;
import com.ak.demo.mapper.UserMapper;
import com.ak.demo.serivce.DataSourceService;
import com.ak.framework.datasource.DataSourceBeanBuilder;
import com.ak.framework.datasource.DataSourceHolder;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    private DataSourceMapper dataSourceDao;
    
    @Autowired
    private UserMapper userDao;

	@Override
	public boolean testTransaction(User user) {
        if (userDao.insert(user) < 0) {
            throw new BusinessException("新增失败");
        }
		return false;
	}

	@Override
	public boolean testMultiDataSource(User user) {
		//先向默认数据源插入
        if (userDao.insert(user) < 0) {
            throw new BusinessException("主库新增失败");
        }
        DataSourceHolder.clearDataSource();
        System.out.println("=========="+dataSourceDao.queryDatasource("testbackup").get("datasource_name"));
        
        //再向起他数据源插入
        /*List<DataSourceDO> dataSourceDOList = this.dataSourceDao.query();
        for (DataSourceDO dataSourceDO : dataSourceDOList) {
            DataSourceBeanBuilder builder = new DataSourceBeanBuilder(DataSourceDO);
            DataSourceHolder.setDataSource(builder);
            if (!userDao.createUser(userDO)) {
                throw new BusinessException(ErrorEnum.TEST_MULTI_DATASOURCE_EXCEPTION);
            }
            DataSourceHolder.clearDataSource();
        }*/
        
        // 向用户库插入业务数据     sct_workflow 为当前登陆用户对应的
        DataSourceBeanBuilder builder1 = new DataSourceBeanBuilder(this.dataSourceDao.queryByDatasourceName("testbackup"));
        DataSourceHolder.setDataSource(builder1);
        if (userDao.insert(user) < 0) {
            throw new BusinessException("testbackup新增失败");
        }
        DataSourceHolder.clearDataSource();
        
        Map<String, String> dataSourceABC = this.dataSourceDao.queryByDatasourceName("abc");
	        if (dataSourceABC != null) {
	        DataSourceBeanBuilder builder = new DataSourceBeanBuilder(dataSourceABC);
	        DataSourceHolder.setDataSource(builder);
	        if (userDao.insert(user) < 0) {
	            throw new BusinessException("abc新增失败");
	        }
	        DataSourceHolder.clearDataSource();
        }
		return false;
	}
}
