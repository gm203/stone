package com.ak.visualization.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.common.core.controller.BaseController;
import com.ak.common.core.domain.AjaxResult;
import com.ak.common.core.domain.AjaxResult.Type;
import com.ak.visualization.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author Vean
 * @version 2019-4-8
 */
@CrossOrigin(origins = "*", maxAge = 3600) 
@RestController
@RequestMapping(value = "/rest/visual")
@Api(value = "可视化接口", tags = "可视化终端数据接口")
public class CustomerRestController extends BaseController {
	
	@Autowired private ICustomerService customerService;

	@RequestMapping(value = {"customerCount"},method ={RequestMethod.GET})
    @ApiOperation(value="终端客户总数", notes="获取终端客户总数")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=false)
    public AjaxResult customerCount(@RequestParam(required=false) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getCustomerCount(provinceId));
    }
	
	@RequestMapping(value = {"customerAddLastMonth"},method ={RequestMethod.GET})
    @ApiOperation(value="上月增长总数", notes="获取上个月终端客户增长总数")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=false)
    public AjaxResult customerAddLastMonth(@RequestParam(required=false) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getCustomerAddLastMonth(provinceId));
    }
	
	@RequestMapping(value = {"orderCount"},method ={RequestMethod.GET})
    @ApiOperation(value="终端客户订单总数", notes="获取终端客户订单总数")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=false)
    public AjaxResult orderCount(@RequestParam(required=false) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getOrderCount(provinceId));
    }
	
	@RequestMapping(value = {"orderSum"},method ={RequestMethod.GET})
    @ApiOperation(value="终端客户总成交金额", notes="获取终端客户总成交金额")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=false)
    public AjaxResult orderSum(@RequestParam(required=false) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getOrderSum(provinceId));
    }
	
	@RequestMapping(value = {"goodsCount"},method ={RequestMethod.GET})
    @ApiOperation(value="终端出售商品总数量", notes="获取终端出售商品总数量")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=false)
    public AjaxResult goodsCount(@RequestParam(required=false) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getGoodsCount(provinceId));
    }
	
	@RequestMapping(value = {"province"},method ={RequestMethod.GET})
    @ApiOperation(value="省份数据", notes="省份数据")
    public AjaxResult province(HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getProvinceCustom(null));
    }
	
	@RequestMapping(value = {"city"},method ={RequestMethod.GET})
    @ApiOperation(value="根据省份ID获取地市数据", notes="根据省份ID获取地市数据")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=true)
    public AjaxResult city(@RequestParam(required=true) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getCityByProvinceId(provinceId));
    }
	
	@RequestMapping(value = {"salesNew10"},method ={RequestMethod.GET})
    @ApiOperation(value="实时交易情况更新", notes="获取最新的10条交易信息")
    public AjaxResult salesNew10(HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getSalesNew10());
    }
	
	@RequestMapping(value = {"customerType"},method ={RequestMethod.GET})
    @ApiOperation(value="终端客户类型分布", notes="获取终端客户类型分布数据")
	@ApiImplicitParam(name = "provinceId", value = "省份ID", dataType = "Long", paramType="query", required=false)
    public AjaxResult customerType(@RequestParam(required=false) Long provinceId, HttpServletRequest request, HttpServletResponse response) {
		return new AjaxResult(Type.SUCCESS, "", customerService.getCustomerType(provinceId));
    }
	
	@RequestMapping(value = {"salesTop5"},method ={RequestMethod.GET})
    @ApiOperation(value="上一年成交量Top5的終端客戶", notes="获取上一年成交量Top5的終端客戶数据")
    public AjaxResult salesTop5(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, String>> date = customerService.getSalesTop5();
		
		List<Object> customname = new ArrayList<Object>();
		List<Object> total = new ArrayList<Object>();
		for (Map<String, String> map : date) {
			total.add(map.get("total"));
			customname.add(map.get("customname"));
		}
		
		Map<String, List<Object>> resultDate = new HashMap<String, List<Object>>();
		resultDate.put("xData", total);
		resultDate.put("yData", customname);
		
		return new AjaxResult(Type.SUCCESS, "", resultDate);
    }
	
	@RequestMapping(value = {"customTop5"},method ={RequestMethod.GET})
    @ApiOperation(value="終端客戶分布前5的省份", notes="获取終端客戶分布前5的省份")
    public AjaxResult customTop5(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, String>> date = customerService.getProvinceCustom(5);
		
		List<Object> customname = new ArrayList<Object>();
		List<Object> total = new ArrayList<Object>();
		for (Map<String, String> map : date) {
			total.add(map.get("total"));
			customname.add(map.get("provincename"));
		}
		
		Map<String, List<Object>> resultDate = new HashMap<String, List<Object>>();
		resultDate.put("xData", total);
		resultDate.put("yData", customname);
		
		return new AjaxResult(Type.SUCCESS, "", resultDate);
    }
}
