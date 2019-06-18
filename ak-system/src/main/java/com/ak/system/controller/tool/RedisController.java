package com.ak.system.controller.tool;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ak.common.core.controller.BaseController;
import com.ak.common.core.domain.AjaxResult;
import com.ak.common.core.domain.AjaxResult.Type;
import com.ak.framework.util.RedisUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rest/redis")
@Api(value = "Redis云数据缓存接口", tags = "Redis云数据缓存接口")
public class RedisController extends BaseController {

	@Autowired
	private RedisUtils redisUtils;

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis Test信息(Content-Type为text/html)", notes = "Redis Test(Content-Type为text/html)")
	public String test() {
		redisUtils.set("Redis Test", "Redis Test");
		String string = redisUtils.get("Redis Test").toString();
		return string;
	}

	/**
	 * 批量删除对应的value
	 *
	 * @param keys
	 */
	@RequestMapping(value = "/removeList", method = { RequestMethod.DELETE })
	@ApiOperation(value = "Redis remove接口(Content-Type为text/html)", notes = "Redis remove接口(Content-Type为text/html)")
	public AjaxResult removeList(@RequestParam(required = false) String keys) {
		String[] keysList = keys.split(",");
		for (String key : keysList) {
			redisUtils.remove(key);
		}
		return success("移除成功");
	}

	/**
	 * 批量删除key
	 *
	 * @param pattern
	 */
	@RequestMapping(value = "/removePattern", method = { RequestMethod.DELETE })
	@ApiOperation(value = "Redis remove pattern接口(Content-Type为text/html)", notes = "Redis remove pattern接口接口(Content-Type为text/html)")
	public AjaxResult removePattern(@RequestParam(required = false) String pattern) {
		redisUtils.removePattern(pattern);
		return success("移除成功");
	}

	@RequestMapping(value = "/removePatternShiroRedis", method = { RequestMethod.DELETE })
	@ApiOperation(value = "Redis remove pattern Shiro Reids接口(Content-Type为text/html)", notes = "Redis remove pattern Shiro Reids接口接口(Content-Type为text/html)")
	public AjaxResult removePatternShiroReids(@RequestParam(required = false) String pattern) {
		redisUtils.removePatternShiroReids(pattern);
		return success("移除成功");
	}

	/**
	 * 删除对应的value
	 *
	 * @param key
	 */
	@RequestMapping(value = "/remove", method = { RequestMethod.DELETE })
	@ApiOperation(value = "Redis remove接口(Content-Type为text/html)", notes = "Redis remove接口(Content-Type为text/html)")
	public AjaxResult remove(@RequestParam(required = false) String key) {
		redisUtils.remove(key);
		return success("移除成功");
	}

	/**
	 * 判断缓存中是否有对应的value
	 *
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/exists", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis exists接口(Content-Type为text/html)", notes = "Redis exists接口(Content-Type为text/html)")
	public AjaxResult exists(@RequestParam(required = false) String key) {
		if (redisUtils.exists(key)) {
			return success("存在！");
		} else {
			return error("不存在！");
		}
	}

	/**
	 * 读取缓存
	 *
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get接口(Content-Type为text/html)", notes = "Redis get接口(Content-Type为text/html)")
	public AjaxResult get(@RequestParam(required = false) String key) {
		if (redisUtils.exists(key)) {
			return new AjaxResult(Type.SUCCESS, "成功", redisUtils.get(key));
		} else {
			return error("不存在！");
		}
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/set", method = { RequestMethod.POST })
	@ApiOperation(value = "Redis set接口(Content-Type为text/html)", notes = "Redis set接口(Content-Type为text/html)")
	public AjaxResult set(@RequestParam(required = false) String key, @RequestParam(required = false) String value) {
		if (redisUtils.set(key, value)) {
			AjaxResult result = error("添加/更新成功！");
			return result;
		} else {
			return error("添加/更新失败！");
		}
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	@RequestMapping(value = "/setExpireTime", method = { RequestMethod.POST })
	@ApiOperation(value = "Redis set expireTime接口(Content-Type为text/html)", notes = "Redis set expireTime接口接口(Content-Type为text/html)")
	public AjaxResult set(@RequestParam(required = false) String key, @RequestParam(required = false) String value,
			@RequestParam(required = false) Long expireTime) {
		if (redisUtils.set(key, value, expireTime)) {
			AjaxResult result = success("添加/更新成功！");
			return result;
		} else {
			return error("添加/更新失败！");
		}
	}

	/**
	 * 获取keys
	 *
	 * @param pattern
	 */
	@RequestMapping(value = "/getKyes", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get kyes接口(Content-Type为text/html)", notes = "Redis get kyes接口接口(Content-Type为text/html)")
	public AjaxResult getKyes(@RequestParam(required = false) String pattern) {
		Set<String> keys = redisUtils.getKyes(pattern);
		AjaxResult result = success("获取Keys成功！");
		result.setData(keys);
		return result;
	}

	@RequestMapping(value = "/getKyesAll", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get kyes all接口(Content-Type为text/html)", notes = "Redis get kyes all接口(Content-Type为text/html)")
	public AjaxResult getKyesAll() {
		Set<String> keys = redisUtils.getKyesAll();
		AjaxResult result = success("获取Keys成功！");
		result.setData(redisUtils.get(keys.stream().findFirst().get()));
		return result;
	}

	/**
	 * 获取keys
	 *
	 * @param pattern
	 */
	@RequestMapping(value = "/getCount", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get count接口(Content-Type为text/html)", notes = "Redis get count接口(Content-Type为text/html)")
	public AjaxResult getCount(@RequestParam(required = false) String pattern) {
		AjaxResult result = success("获取数量成功！");
		result.setData(redisUtils.getCount());
		return result;
	}

	@RequestMapping(value = "/getCountShiro", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get count shiro接口(Content-Type为text/html)", notes = "Redis get count shiro接口(Content-Type为text/html)")
	public AjaxResult getCountShiro(@RequestParam(required = false) String pattern) {
		AjaxResult result = success("获取数量成功！");
		result.setData(redisUtils.getCountShiro());
		return result;
	}

	/**
	 * 获取token的有效期（秒）
	 * 
	 * @param key
	 */
	@RequestMapping(value = "/getExpireTime", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get ExpireTime接口(Content-Type为text/html)", notes = "Redis get ExpireTime接口接口(Content-Type为text/html)")
	public AjaxResult getExpireTime(@RequestParam(required = false) String key) {
		AjaxResult result = success("获取token的有效期（秒）成功！");
		result.setData(redisUtils.getExpireTime(key));
		return result;
	}

	/**
	 * 获取缓存有效期成功
	 */
	@RequestMapping(value = "/getExpire", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get getExpire(Content-Type为text/html)", notes = "Redis get getExpire(Content-Type为text/html)")
	public AjaxResult getExpire() {
		AjaxResult result = success("获取缓存有效期成功！");
		result.setData(RedisUtils.getExpire());
		return result;
	}

	/**
	 * 获取单点登录缓存有效期成功
	 */
	@RequestMapping(value = "/getExpireShiro", method = { RequestMethod.GET })
	@ApiOperation(value = "Redis get getExpireShiro(Content-Type为text/html)", notes = "Redis get getExpireShiro(Content-Type为text/html)")
	public AjaxResult getExpireShiro() {
		AjaxResult result = success("获取单点登录缓存有效期成功！");
		result.setData(RedisUtils.getExpireShiro());
		return result;
	}
}