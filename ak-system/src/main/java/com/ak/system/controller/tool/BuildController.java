package com.ak.system.controller.tool;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ak.common.core.controller.BaseController;

/**
 * build 表单构建
 * 
 * @author ak
 */
@Controller
@RequestMapping("/tool/build")
public class BuildController extends BaseController {
	private String prefix = "tool/build";

	@RequiresPermissions("tool:build:view")
	@GetMapping()
	public String build() {
		return prefix + "/build";
	}
}
