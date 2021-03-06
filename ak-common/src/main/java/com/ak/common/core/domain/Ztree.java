package com.ak.common.core.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Ztree树结构实体类
 * 
 * @author ak
 */
public class Ztree implements Serializable {

	private static final long serialVersionUID = 5488785099339809677L;

	/** 节点ID */
	@Getter
	@Setter
	private Long id;

	/** 节点父ID */
	private Long pId;

	/** 节点名称 */
	@Getter
	@Setter
	private String name;

	/** 节点标题 */
	@Getter
	@Setter
	private String title;

	/** 是否勾选 */
	private boolean checked = false;

	/** 是否展开 */
	private boolean open = false;

	/** 是否能勾选 */
	private boolean nocheck = false;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isNocheck() {
		return nocheck;
	}

	public void setNocheck(boolean nocheck) {
		this.nocheck = nocheck;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}
}
