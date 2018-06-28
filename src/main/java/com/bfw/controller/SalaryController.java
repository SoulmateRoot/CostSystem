/**
 * Project Name:costone
 * File Name:SalaryController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��26������5:40:31
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bfw.bean.SalaryPayment;
import com.bfw.bean.UserInfo;
import com.bfw.service.ISalaryPaymentService;
import com.bfw.service.IUserInfoService;
import com.bfw.utils.Comm;
import com.bfw.utils.Page;

/**
 * ClassName:SalaryController <br/>
 * Function: н�ʹ�������� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��26�� ����5:40:31 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/salary/")
public class SalaryController extends Page{
	//н�ʹ�������ע��
	@Autowired
	private ISalaryPaymentService SalaryService;
	//�û�����ע��
	@Autowired
	private IUserInfoService UserService;
	
/**
 * @Title: loadadd  
 * @Description:н�ʹ�����ӷ��� 
 * @param model
 * @return      
 * @return String    
 * @throws
 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model ){
		//ʵ�����û������ò�ѯ��Ч���û�
		UserInfo user=new UserInfo();
		user.setUserMark(Comm.MARK_YES);
		user.setStart(-1);
		List<UserInfo> userlist=UserService.list(user);
		model.addAttribute("userlist",userlist);
		return "salary/salary_add";
	}
	//��ӷ���
	@RequestMapping("add.do")
	public String add(SalaryPayment sp,Model model ){
		try {
			SalaryService.add(sp);
			model .addAttribute("errorinfo", "н�ʷ��ųɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo","н�ʷ���ʧ��");
			
		}
		
		return loadadd(model);
	}
	

	/**
	 * @Title: initBinder  
	 * @Description:ʱ�����Ա༭��  ʱ���ʽת��
	 * @param bin      
	 * @return void    
	 * @throws
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	/**
	 * @Title: list  
	 * @Description:н�ʷ��ż�¼��ѯ
	 * @param sp
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("list.do")
	public String list(SalaryPayment sp,Model model ,HttpServletRequest request){
		//1.�����жϴ���������Ƿ�Ϊ��
		if (sp==null ) {
			sp=new SalaryPayment();
		}
		//2.���÷�ҳ��Ϣ
		this.initPage(request);
		//��ʼҳ
		sp.setStart(this.getPageNo());
		//ÿҳ��ʾ��¼��
		sp.setLength(PAGE_NUM_BIG);
		//��װ����
		model.addAttribute("list",SalaryService.list(sp));
		model.addAttribute("total",SalaryService.getcount(sp));
		model.addAttribute("salaryPayment", sp);
		return "salary/salary_list";
	}
	/**
	 * @Title: impExcel  
	 * @Description: ����Excelн�ʼ�¼����  
	 * @param sp
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	//@RequestParam���:  https://blog.csdn.net/a350204530/article/details/60763379
	@RequestMapping("impexcel.do")
	public String impExcel(SalaryPayment sp,@RequestParam(value="file",required=false)MultipartFile file,Model model ,HttpServletRequest request){
		if (sp == null) {
			new SalaryPayment();
		}
		//�ϴ���ַ
		String path=request.getSession().getServletContext().getRealPath("\\upload\\");
		System.out.println(path);
		String filename=file.getOriginalFilename();
		File targerfile=new File(path,new Date()+filename);
		try{
			SalaryService.BatchAdd(file.getInputStream());
			file.transferTo(targerfile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list(null, model, request);
	}
	

}

