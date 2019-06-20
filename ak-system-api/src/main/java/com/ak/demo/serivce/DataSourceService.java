package com.ak.demo.serivce;

import com.ak.demo.domain.User;

public interface DataSourceService {
	
    boolean testTransaction(User user);

    boolean testMultiDataSource(User user);
}
