package com.bfw.service;

import java.util.List;
import java.util.Map;

import com.bfw.bean.RoleMenuInfo;

/**
 * 
 * ClassName: IAnthorityService <br/>
 * Function:Ȩ�޹����ҵ���߼��ӿ� <br/>
 * Reason: TODO ADD REASON(��ѡ). <br/>
 * date: 2018��6��11�� ����6:01:58 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
public interface IAnthorityService {

	/**
	 * ���
	 * @param roleId
	 * @param menuIds
	 */
	public void add(Integer roleId,Integer[] menuIds);
	
	/**
	 * ���ݽ�ɫ��Ų�ѯ�Ѿ�ѡ��Ĳ˵����
	 * @param info
	 * @return
	 */
	public List<RoleMenuInfo> list(RoleMenuInfo info);
	
	/**
	 * ���ݽ�ɫ��Ų�ѯ�˵���Ϣ
	 * @param roleId
	 * @return
	 */
	public List<Map> getMenuList(Integer roleId);
	
}
