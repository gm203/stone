package com.ak.visualization.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.common.utils.DateUtils;
import com.ak.visualization.mapper.CustomerMapper;

/**
 * 可视化Service
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	/**  终端客户总数  **/
	@Override
	public Long getCustomerCount(Long provinceId) {
		return customerMapper.getCustomerCount(provinceId);
	}
	
	/**  上个月增长数据量  **/
	@Override
	public Long getCustomerAddLastMonth(Long provinceId) {
		return customerMapper.getCustomerAddLastMonth(provinceId);
	}
	
	/**  订单总数  **/
	@Override
	public Long getOrderCount(Long provinceId) {
		return customerMapper.getOrderCount(provinceId);
	}
	
	/**  订单总金额  **/
	@Override
	public Long getOrderSum(Long provinceId) {
		return customerMapper.getOrderSum(provinceId);
	}
	
	/**  终端出售商品总数量  **/
	@Override
	public Long getGoodsCount(Long provinceId) {
		return customerMapper.getGoodsCount(provinceId);
	}
	
	/**  根据省份ID获取市  **/
	@Override
	public List<Map<String, String>> getCityByProvinceId(Long provinceId) {
		return customerMapper.getCityByProvinceId(provinceId);
	}
	
	/**  实时交易情况更新  **/
	@Override
	public List<Map<String, String>> getSalesNew10() {
		return customerMapper.getSalesNew10();
	}
	
	/**  终端客户类型分布  **/
	@Override
	public List<Map<String, String>> getCustomerType(Long provinceId) {
		return customerMapper.getCustomerType(provinceId);
	}
	
	/**  上一年成交量Top5的終端客戶  **/
	@Override
	public List<Map<String, String>> getSalesTop5(){
		return customerMapper.getSalesTop5(DateUtils.getLastYearFirstDate(), DateUtils.getCurrentYearFirstDate());
	}
	
	/**  終端客戶分布前5的省份  **/
	@Override
	public List<Map<String, String>> getProvinceCustom(Integer beginDate){
		return customerMapper.getProvinceCustom(beginDate);
	}
}