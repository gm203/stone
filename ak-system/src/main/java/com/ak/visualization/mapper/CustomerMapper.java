package com.ak.visualization.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 用户中心DAO接口
 * @version 2017-12-12
 */
public interface CustomerMapper {
	
	Long getCustomerCount(@Param("provinceId")Long provinceId);
	
	Long getCustomerAddLastMonth(@Param("provinceId")Long provinceId);
	
	Long getOrderCount(@Param("provinceId")Long provinceId);
	
	Long getOrderSum(@Param("provinceId")Long provinceId);
	
	Long getGoodsCount(@Param("provinceId")Long provinceId);
	
	List<Map<String, String>> getCityByProvinceId(@Param("provinceId")Long provinceId);
	
	List<Map<String, String>> getSalesNew10();
	
	List<Map<String, String>> getCustomerType(@Param("provinceId")Long provinceId);
	
	List<Map<String, String>> getSalesTop5(@Param("beginDate")String beginDate, @Param("endDate")String endDate);
	
	List<Map<String, String>> getProvinceCustom(@Param("top")Integer beginDate);
}