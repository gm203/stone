package com.ak.visualization.service;

import java.util.List;
import java.util.Map;

/**
 * 可视化Service
 */
public interface ICustomerService {

	/**  终端客户总数  **/
	public Long getCustomerCount(Long provinceId);
	
	/**  上个月增长数据量  **/
	public Long getCustomerAddLastMonth(Long provinceId);
	
	/**  订单总数  **/
	public Long getOrderCount(Long provinceId);
	
	/**  订单总金额  **/
	public Long getOrderSum(Long provinceId);
	
	/**  终端出售商品总数量  **/
	public Long getGoodsCount(Long provinceId);
	
	/**  根据省份ID获取市  **/
	public List<Map<String, String>> getCityByProvinceId(Long provinceId);
	
	/**  实时交易情况更新  **/
	public List<Map<String, String>> getSalesNew10();
	
	/**  终端客户类型分布  **/
	public List<Map<String, String>> getCustomerType(Long provinceId);
	
	/**  上一年成交量Top5的終端客戶  **/
	public List<Map<String, String>> getSalesTop5();
	
	/**  終端客戶分布前5的省份  **/
	public List<Map<String, String>> getProvinceCustom(Integer beginDate);
}