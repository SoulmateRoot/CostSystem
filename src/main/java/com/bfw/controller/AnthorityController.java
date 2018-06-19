package com.bfw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.MenuInfo;
import com.bfw.bean.RoleInfo;
import com.bfw.bean.RoleMenuInfo;
import com.bfw.service.IAnthorityService;
import com.bfw.service.IMenuInfoService;
import com.bfw.service.IRoleInfoService;
import com.bfw.utils.Page;

/**
 * 
 * ClassName: AnthorityController <br/>
 * Function:Ȩ�޹���Ŀ�����. <br/>
 * Reason: TODO ADD REASON(��ѡ). <br/>
 * date: 2018��6��12�� ����3:05:48 <br/>
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/anthority/")
public class AnthorityController extends Page{

	/**
	 * ��ɫ�����ҵ���߼��ӿ�
	 */
	@Autowired
	private IRoleInfoService roleservice;
	
	/**
	 * �˵������ҵ���߼��ӿ�
	 */
	@Autowired
	private IMenuInfoService menuservice;
	
	/**
	 * Ȩ�޹����ҵ���߼��ӿ�
	 */
	@Autowired
	private IAnthorityService anservice;
	
	/**
	 * ��ѯ��ɫ
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(RoleInfo info,Model model,HttpServletRequest request){
		
		if(info==null){
			info = new RoleInfo();
		}
		//��ҳ��Ϣ
		this.initPage(request);
		//��ʼ��¼
		info.setStart(this.getPageNo());
		//ÿҳ��ʾ��¼��
		info.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", roleservice.list(info));
		//�ܼ�¼��
		model.addAttribute("total", roleservice.getcount(info));
		
		return "anthority/anthority_list";
	}
	
	/**
	 * Ȩ�ޱ��
	 * @return
	 */
	@RequestMapping("loadchange.do")
	public String loadchange(RoleInfo info,Model model){
		
		//��ɫ��Ϣ
		RoleInfo role = roleservice.getInfo(info);
		model.addAttribute("role", role);
		
		//��ѯ���еĲ˵���Ϣ
		List<MenuInfo> list = menuservice.list(null);
		model.addAttribute("list", list);
		
		//��ѯ����Ȩ��
		RoleMenuInfo rminfo = new RoleMenuInfo();
		rminfo.setRoleId(info.getRoleId());
		List<RoleMenuInfo> rmlist = anservice.list(rminfo);
		model.addAttribute("rmlist", rmlist);
		
		return "anthority/anthority_change";
		
	}
	
	/**
	 * Ȩ�ޱ��
	 * @return
	 */
	@RequestMapping("change.do")
	public String change(Integer roleId,Integer[] menuIds,Model model,HttpServletRequest request){
		
	
		try {
			anservice.add(roleId, menuIds);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo", "���ʧ��");
		}
		
		
		return list(null,model,request);
	}
	
}
