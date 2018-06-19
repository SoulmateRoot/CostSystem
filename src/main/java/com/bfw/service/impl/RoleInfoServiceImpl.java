/**
 * Project Name:costone
 * File Name:RoleInfoServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018年5月27日下午3:04:15
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.RoleInfo;
import com.bfw.dao.IRoleInfoDAO;
import com.bfw.service.IRoleInfoService;
import com.bfw.utils.Comm;

/**
 * ClassName:RoleInfoServiceImpl <br/>
 * Function: 角色管理业务逻辑实现类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月27日 下午3:04:15 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class RoleInfoServiceImpl implements IRoleInfoService{
	
	@Autowired
	private IRoleInfoDAO roledao;
	
	/**
	 * 
	 * TODO 角色管理添加方法
	 * @see com.bfw.service.IRoleInfoService#add(com.bfw.bean.RoleInfo)
	 */
	
	public void add(RoleInfo info){
		roledao.add(info);
	}

	/**
	 * 
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.bfw.service.IRoleInfoService#list(com.bfw.bean.RoleInfo)
	 */
	public List<RoleInfo> list(RoleInfo info) {
		condition(info);
		return roledao.list(info);
	}

	/**
	 * 
	 * TODO 简单描述该方法的实现功能（可选）.
	 * @see com.bfw.service.IRoleInfoService#getcount(com.bfw.bean.RoleInfo)
	 */
	public long getcount(RoleInfo info) {
		condition(info);
		return roledao.getcount(info);
	}
	
	/**
	 * 
	 * condition:(查询条件). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public void condition(RoleInfo info){
		if(info!=null){
			info.setRoleMark(Comm.MARK_YES);
			if(info.getRoleName()!=null &&!info.getRoleName().equals("")){
				info.setRoleName("%"+info.getRoleName()+"%");
			}
		}
		
	}
	
	/**
	 * 
	 * TODO 根据角色查询信息.
	 * @see com.bfw.service.IRoleInfoService#getInfo(com.bfw.bean.RoleInfo)
	 */
	public RoleInfo getInfo(RoleInfo info) {
		
		return roledao.getinfo(info);
	}

	/**
	 * 
	 * TODO 修改角色信息.
	 * @see com.bfw.service.IRoleInfoService#update(com.bfw.bean.RoleInfo)
	 */
	public void update(RoleInfo info) {
		roledao.update(info);
		
	}

	
	/**
	 * 
	 * TODO 根据编号进行假删除.
	 * @see com.bfw.service.IRoleInfoService#delete(java.lang.Integer[])
	 */
	public void delete(Integer[] roleId) {
		for(Integer id:roleId){
			
			RoleInfo info = new RoleInfo();
			//获取当前id
			info.setRoleId(id);
			//修改无效标示
			info.setRoleMark(Comm.MARK_NO);
			//其实删除做的是修改
			roledao.update(info);
		}
		
	}
	
//类结尾
}

