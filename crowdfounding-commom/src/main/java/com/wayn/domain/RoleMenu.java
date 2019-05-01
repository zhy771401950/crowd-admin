package com.wayn.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 角色菜单关联表
 * </p>
 *
 * @author wayn
 * @since 2019-04-13
 */
@TableName("sys_role_menu")
public class RoleMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.UUID)
	private String id;

	/**
	 * 角色主键
	 */
	private String roleId;

	/**
	 * 菜单主键
	 */
	private Long menuId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "RoleMenu{" + "id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + "}";
	}
}
