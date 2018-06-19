package com.bfw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.RoleMenuInfo;
import com.bfw.dao.IAnthorityDAO;
import com.bfw.service.IAnthorityService;

/**
 * 
 * ClassName: AnthorityServiceImpl <br/>
 * Function: 权限管理 <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月12日 下午3:07:22 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
@Service
@Transactional
public class AnthorityServiceImpl implements IAnthorityService {
	//权限变更的数据访问接口  依赖自动注入
	@Autowired
	private IAnthorityDAO andao;
	
	/**
	 * 
	 * TODO 业务逻辑实现  添加修改角色权限.
	 * @see com.bfw.service.IAnthorityService#add(java.lang.Integer, java.lang.Integer[])
	 */
	public void add(Integer roleId, Integer[] menuIds) {
		//1. 首先调用service 根据角色ID删除权限===要修改先删除
		andao.delete(roleId);
		//2.将传入的权限信息
		for (Integer menuId : menuIds) {
			RoleMenuInfo info = new RoleMenuInfo();
			info.setRoleId(roleId);
			info.setMenuId(menuId);
			andao.add(info);
		}
	}

	/**
	 * 
	 * TODO 根据条件查询已选择的菜单）.
	 * @see com.bfw.service.IAnthorityService#list(com.bfw.bean.RoleMenuInfo)
	 */
	public List<RoleMenuInfo> list(RoleMenuInfo info) {
		return andao.list(info);
	}
	
	/**
	 * 
	 * TODO 根据角色编号查询菜单信息）.
	 * @see com.bfw.service.IAnthorityService#getMenuList(java.lang.Integer)
	 */
	public List<Map> getMenuList(Integer roleId) {
		return andao.getMenuList(roleId);
	}

}
