package com.wayn.domain.vo;

import java.util.Date;

public class RoleChecked {

	private String id;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色描述
	 */
	private String roleDesc;

	/**
	 * 状态,1-启用,-1禁用
	 */
	private Integer roleState;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * role多选框，是否选中标志
	 */
	private boolean checked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleState() {
		return roleState;
	}

	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "RoleChecked [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", roleState="
				+ roleState + ", createTime=" + createTime + ", checked=" + checked + "]";
	}

}
