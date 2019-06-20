package com.ak.demo.domain;

import java.util.Date;

import lombok.Data;

@Data
public class DataSource {
    private String datasourceName;
    private String databaseIp;
    private String databasePort;
    private String databaseName;
    private String username;
    private String password;
    private Date gmtCreate;
	private Date gmtModified;
}
