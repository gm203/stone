package com.ak.common.utils;

import com.ak.common.config.Global;
import com.ak.common.json.JSON;
import com.ak.common.json.JSONObject;
import com.ak.common.utils.http.HttpUtils;

import lombok.extern.log4j.Log4j2;

/**
 * 获取地址类
 * 
 * @author ak
 */
@Log4j2
public class AddressUtils {

	public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

	public static String getRealAddressByIP(String ip) {
		String address = "XX XX";

		// 内网不查询
		if (IpUtils.internalIp(ip)) {
			return "内网IP";
		}
		if (Global.isAddressEnabled()) {
			String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
			if (StringUtils.isEmpty(rspStr)) {
				log.error("获取地理位置异常 {}", ip);
				return address;
			}
			JSONObject obj;
			try {
				obj = JSON.unmarshal(rspStr, JSONObject.class);
				JSONObject data = obj.getObj("data");
				String region = data.getStr("region");
				String city = data.getStr("city");
				address = region + " " + city;
			} catch (Exception e) {
				log.error("获取地理位置异常 {}", ip);
			}
		}
		return address;
	}
}
