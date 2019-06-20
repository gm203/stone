package com.ak.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.demo.domain.User;
import com.ak.demo.serivce.DataSourceService;
import com.ak.demo.serivce.UserService;

/**
 * @Author caiChaoqi
 * @Date 2018-06-23
 */
@RestController
public class DataSourceController {

	@Resource
    private DataSourceService dataSourceService;
    
	@Resource
    private UserService userService;

	@RequestMapping("/testTransaction")
    public void testTransaction(User user) {
	    dataSourceService.testTransaction(user);
    }
    
	@RequestMapping("/testMultiDataSource")
    public void testMultiDataSource(User user) {
	    dataSourceService.testMultiDataSource(user);
    }
}
