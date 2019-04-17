package com.ak.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ak.common.annotation.Excel;
import com.ak.common.core.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 角色表 sys_role
 * 
 * @author ak
 */
@Getter
@Setter
public class SysRole extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 角色ID */
	@Excel(name = "角色序号")
	private Long roleId;

	/** 角色名称 */
	@Excel(name = "角色名称")
	private String roleName;

	/** 角色权限 */
	@Excel(name = "角色权限")
	private String roleKey;

	/** 角色排序 */
	@Excel(name = "角色排序")
	private String roleSort;

	/** 数据范围（1：所有数据权限；2：自定数据权限） */
	@Excel(name = "数据范围", readConverterExp = "1=所有数据权限,2=自定义数据权限")
	private String dataScope;

	/** 角色状态（0正常 1停用） */
	@Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
	private String status;

	/** 用户是否存在此角色标识 默认不存在 */
	private boolean flag = false;

	/** 菜单组 */
	private Long[] menuIds;

	/** 部门组（数据权限） */
	private Long[] deptIds;

	public Long[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(Long[] menuIds) {
		this.menuIds = menuIds;
	}

	public Long[] getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(Long[] deptIds) {
		this.deptIds = deptIds;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("roleId", getRoleId())
				.append("roleName", getRoleName()).append("roleKey", getRoleKey()).append("roleSort", getRoleSort())
				.append("dataScope", getDataScope()).append("status", getStatus()).append("delFlag", getDelFlag())
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
				.toString();
	}
}
