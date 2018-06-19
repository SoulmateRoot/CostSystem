/**
 * Project Name:costone
 * File Name:RoleInfoDao.java
 * Package Name:com.bfw.dao
 * Date:2018年5月27日下午2:49:04
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import javax.management.relation.Role;

import com.bfw.bean.RoleInfo;

/**
 * ClassName:RoleInfoDao <br/>
 * Function: 角色管理的数据访问接口 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月27日 下午2:49:04 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IRoleInfoDAO {
	
	/**
	 * 
	 * add:(添加角色方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public int add(RoleInfo info);
	
	/**
	 * 
	 * update:(修改角色方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public int update(RoleInfo info);
	
	

	/**
	 * 
	 * list:(根据条件查询角色信息列表). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public List<RoleInfo> list(RoleInfo info);
	
	/**
	 * 
	 * getcount:(获取总记录数). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public long getcount(RoleInfo info);
	
	/**
	 * 
	 * getinfo:(根据条件查询角色信息，修改页面). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public RoleInfo getinfo(RoleInfo info);

}

