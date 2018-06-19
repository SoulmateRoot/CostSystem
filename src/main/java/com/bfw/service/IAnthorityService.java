package com.bfw.service;

import java.util.List;
import java.util.Map;

import com.bfw.bean.RoleMenuInfo;

/**
 * 
 * ClassName: IAnthorityService <br/>
 * Function:权限管理的业务逻辑接口 <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月11日 下午6:01:58 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
public interface IAnthorityService {

	/**
	 * 添加
	 * @param roleId
	 * @param menuIds
	 */
	public void add(Integer roleId,Integer[] menuIds);
	
	/**
	 * 根据角色编号查询已经选择的菜单编号
	 * @param info
	 * @return
	 */
	public List<RoleMenuInfo> list(RoleMenuInfo info);
	
	/**
	 * 根据角色编号查询菜单信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getMenuList(Integer roleId);
	
}
