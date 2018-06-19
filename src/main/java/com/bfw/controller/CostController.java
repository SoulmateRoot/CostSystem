/**
 * Project Name:costone
 * File Name:CostController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��22������9:44:03
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.CostInfo;
import com.bfw.service.ICostInfoService;
import com.bfw.utils.Comm;
import com.bfw.utils.Page;

/**
 * ClassName:CostController <br/>
 * Function: ���ù�������� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��22�� ����9:44:03 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/cost/")
public class CostController extends Page{
	
	//����ע��
	@Autowired
	private ICostInfoService costservice;
	
	/**
	 * list:(���ò�ѯ). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("list.do")
	public String list(CostInfo info,Model model,HttpServletRequest request){
		//�ж��û��Ƿ�Ϊ��
		if(info==null){
			info=new CostInfo();
		}
		//��ҳ��Ϣ
		this.initPage(request);
		//��ʼ��¼
		info.setStart(this.getPageNo());
		//������ʾ����
		info.setLength(PAGE_NUM_BIG);
		//������ʾ
		model.addAttribute("list",costservice.list(info));
		model.addAttribute("total",costservice.getcount(info));
		return "cost/cost_list";
	}
	
	/**
	 * loadadd:(���ط������ҳ��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(){
		return "cost/cost_add";
	}
	/**
	 * @Title: add  
	 * @Description:������� 
	 * @param info
	 * @param model
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("add.do")
	public String add(CostInfo info,Model model,HttpServletRequest request){
		try{
			if(info!=null){
				info.setCostMark(Comm.MARK_YES);
			}
			costservice.add(info);
		}catch(Exception e){
			model.addAttribute("errorinfo","�������ʧ��");
			e.printStackTrace();
		}
		return list(null,model,request);
	}
	/**
	 * loadadd:(�����޸�). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(CostInfo info,Model model){
		model.addAttribute("cost",costservice.getinfo(info));
		return "cost/cost_update";
	}
	/**
	 * @Title: update  
	 * @Description:�����޸ķ���
	 * @param info
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("update.do")
	public String update(CostInfo info,Model model,HttpServletRequest request){
		try {
			costservice.update(info);
		} catch (Exception e) {
			//�쳣��Ϣ�׳���ʾ
			model.addAttribute("errorinfo","������Ϣ�޸�ʧ��");
			e.printStackTrace();
		}
		return list(null,model,request);
	}
	/**
	 * @Title: delete  
	 * @Description: ������Ϣɾ������  
	 * @param costid
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("delete.do")
	public String delete(Integer[] costId,Model model,HttpServletRequest request){
		try {
			costservice.delete(costId);
			model.addAttribute("errorinfo", "������Ϣɾ���ɹ�");
		} catch (Exception e) {
			//�쳣��Ϣ�׳���ʾ
			model.addAttribute("errorinfo","������Ϣɾ��ʧ��");
			e.printStackTrace();
		}
		return list(null,model,request);
	}
	
	
	

}

