package com.bfw.dao;

import java.util.List;
import java.util.Map;

import com.bfw.bean.RoleMenuInfo;

/**
 * 
 * <p>Title:IAnthorityDAO </p>
 * <p>Description:权限变更的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IAnthorityDAO {

	/**
	 * 添加角色权限关系信息
	 * @param info
	 * @return
	 */
	public int add(RoleMenuInfo info);
	
	/**
	 * 根据条件查询已选择的菜单
	 * @param info
	 * @return
	 */
	public List<RoleMenuInfo> list(RoleMenuInfo info);
	
	/**
	 * 根据角色编号删除信息
	 * @param roleId
	 * @return
	 */
	public int delete(Integer roleId);
	
	/**
	 * 根据角色编号查询菜单信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getMenuList(Integer roleId);
	
}
