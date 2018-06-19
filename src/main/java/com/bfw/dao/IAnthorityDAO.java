package com.bfw.dao;

import java.util.List;
import java.util.Map;

import com.bfw.bean.RoleMenuInfo;

/**
 * 
 * <p>Title:IAnthorityDAO </p>
 * <p>Description:Ȩ�ޱ�������ݷ��ʽӿ�</p>
 * <p>Company:xxxx</p>
 * @author ��ţ
 * @version 1.0
 */
public interface IAnthorityDAO {

	/**
	 * ��ӽ�ɫȨ�޹�ϵ��Ϣ
	 * @param info
	 * @return
	 */
	public int add(RoleMenuInfo info);
	
	/**
	 * ����������ѯ��ѡ��Ĳ˵�
	 * @param info
	 * @return
	 */
	public List<RoleMenuInfo> list(RoleMenuInfo info);
	
	/**
	 * ���ݽ�ɫ���ɾ����Ϣ
	 * @param roleId
	 * @return
	 */
	public int delete(Integer roleId);
	
	/**
	 * ���ݽ�ɫ��Ų�ѯ�˵���Ϣ
	 * @param roleId
	 * @return
	 */
	public List<Map> getMenuList(Integer roleId);
	
}
