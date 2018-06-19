/**
 * Project Name:costone
 * File Name:CostInfoServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018��6��12������10:57:32
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.CostInfo;
import com.bfw.dao.ICostInfoDAO;
import com.bfw.service.ICostInfoService;
import com.bfw.utils.Comm;

/**
 * ClassName:CostInfoServiceImpl <br/>
 * Function: ���ù���ҵ���߼�ʵ����<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��12�� ����10:57:32 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
//spring֧�ֱ��ʽ������������ʽ����������ַ�ʽ��
//@Transactional���
//https://www.cnblogs.com/yepei/p/4716112.html  
//https://blog.csdn.net/kinseygeek/article/details/54931710
//�������м�����Ҫ������⣺
//A. һ�������Ƿ�Ҫ���񣬱���������ơ����뿼�ǡ����ܽ�������˻������ܾ�ok��
//B. ����������񣬱������ÿ����������ԣ����Ի���Ҳ���������쳣�����Իع�����ȷ��������Ч��
//C. ������������ʹ�ù��̵�ע������������⡣
//1. ��Ҫ�ڽӿ�������@Transactional ����Ҫ�ھ�����ķ�����ʹ�� @Transactional ע�⣬����ע�������Ч��
//2.��Ҫͼʡ�£���@Transactional�������༶�������У���������������ʹ�����з����������񡣹�@TransactionalӦ�÷��ڷ������𣬲���Ҫʹ������ķ������Ͳ�Ҫ�������񣬱����ѯ�������������������Ӱ��ġ�
//3.ʹ����@Transactional�ķ�������ͬһ��������ķ������ã� @Transactional��Ч��������һ����Test������һ������A��A�ٵ���Test����ķ���B������B�Ƿ�public����private������Aû������ע�����񣬶�B�С����ⲿ����A֮��B�������ǲ��������õġ����������������
//4.ʹ����@Transactional�ķ�����ֻ����public��@Transactionalע��ķ������Ǳ��ⲿ��������ò���Ч����ֻ����public�������������й��������� protected��private ���� package-visible �ķ�����ʹ�� @Transactional ע�⣬��Ҳ���ᱨ����������Ч��
//5.������ICORE-CLAIM�в��ԣ�Ч�����£�
//A.�׳��ܲ��쳣XXXException�������ع���
//B.�׳�����ʱ�쳣NullPointerException�������ع���
//C.Quartz�У�executeֱ�ӵ��ü���@Transactional���������Իع�����ӵ��ã�����ع�����������3���ᵽ�ģ�
//D.�첽�����У�executeֱ�ӵ��ü���@Transactional���������Իع�����ӵ��ã�����ع�����������3���ᵽ�ģ�
//E.��action�м���@Transactional������ع����мǲ�Ҫ��action�м�������
//F.��service�м���@Transactional�������actionֱ�ӵ��÷�������ع�������Ǽ�ӵ�������ع�����������3�ᵽ�ģ�
//G.��service�е�private����@Transactional�����񲻻�ع��� 
@Service
@Transactional
public class CostInfoServiceImpl implements ICostInfoService {
	
	//����ע��
	@Autowired
	private ICostInfoDAO costdao;
	

	/**
	 * 
	 * TODO ��ӷ�����Ϣ
	 * @see com.bfw.service.ICostInfoService#add(com.bfw.bean.CostInfo)
	 */
	public void add(CostInfo info) {
		costdao.add(info);

	}
	
	/**
	 * TODO ��ѯ�����б�.
	 * @see com.bfw.service.ICostInfoService#list(com.bfw.bean.CostInfo)
	 */
	@Transactional(readOnly=true)
	public List<CostInfo> list(CostInfo info) {
		condition(info);
		return costdao.list(info);
	}
	
	/**
	 * TODO ҵ���߼� ��ȡ������
	 * @see com.bfw.service.ICostInfoService#getcount(com.bfw.bean.CostInfo)
	 */
	public long getcount(CostInfo info) {
		condition(info);
		return costdao.getcount(info);
	}
	/**
	 * 
	 * TODO ���ط�����Ϣ�޸�ҳ�� ҵ���߼�ʵ�ַ���
	 * @see com.bfw.service.ICostInfoService#getinfo(com.bfw.bean.CostInfo)
	 */
	public CostInfo getinfo(CostInfo info) {
		
		return costdao.getinfo(info);
	}
	/**
	 * 
	 * TODO �޸ķ�����Ϣ ҵ���߼�ʵ�ַ���
	 * @see com.bfw.service.ICostInfoService#update(com.bfw.bean.CostInfo)
	 */
	public void update(CostInfo info) {
		costdao.update(info);
		
	}
	
	/**
	 * 
	 * TODO ����ɾ��ҵ���߼�ʵ����
	 * @see com.bfw.service.ICostInfoService#delete(java.lang.Integer[])
	 */
	public void delete(Integer[] costIds) {
		for(Integer costid:costIds){
			System.out.println(costid);
			CostInfo info=new CostInfo();
			info.setCostId(costid);
			info.setCostMark(Comm.MARK_NO);
			costdao.update(info);
		}
		
	}

	/**
	 * @Title: condition  
	 * @Description:��ѯ�������� 
	 * @param info      
	 * @return void    
	 * @throws
	 */
	public void condition(CostInfo info){
		if(info!=null){
			//����ֻ��ѯ��Ч����
			info.setCostMark(Comm.MARK_YES);
			//�������Ʋ�Ϊ��ʱ�����ò�ѯ����
			if(info.getCostName()!=null &&!info.getCostName().equals("")){
				info.setCostName("%"+info.getCostName()+"%");
			}
		}
	}

	
	

}

