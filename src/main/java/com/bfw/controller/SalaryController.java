/**
 * Project Name:costone
 * File Name:SalaryController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月26日下午5:40:31
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
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
 * Function: 薪资管理控制器 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月26日 下午5:40:31 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/salary/")
public class SalaryController extends Page{
	//薪资管理依赖注入
	@Autowired
	private ISalaryPaymentService SalaryService;
	//用户依赖注入
	@Autowired
	private IUserInfoService UserService;
	
/**
 * @Title: loadadd  
 * @Description:薪资管理添加方法 
 * @param model
 * @return      
 * @return String    
 * @throws
 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model ){
		//实例化用户，设置查询有效的用户
		UserInfo user=new UserInfo();
		user.setUserMark(Comm.MARK_YES);
		user.setStart(-1);
		List<UserInfo> userlist=UserService.list(user);
		model.addAttribute("userlist",userlist);
		return "salary/salary_add";
	}
	//添加方法
	@RequestMapping("add.do")
	public String add(SalaryPayment sp,Model model ){
		try {
			SalaryService.add(sp);
			model .addAttribute("errorinfo", "薪资发放成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo","薪资发放失败");
			
		}
		
		return loadadd(model);
	}
	

	/**
	 * @Title: initBinder  
	 * @Description:时间属性编辑器  时间格式转换
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
	 * @Description:薪资发放记录查询
	 * @param sp
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("list.do")
	public String list(SalaryPayment sp,Model model ,HttpServletRequest request){
		//1.首先判断传入的数据是否为空
		if (sp==null ) {
			sp=new SalaryPayment();
		}
		//2.设置分页信息
		this.initPage(request);
		//起始页
		sp.setStart(this.getPageNo());
		//每页显示记录数
		sp.setLength(PAGE_NUM_BIG);
		//封装数据
		model.addAttribute("list",SalaryService.list(sp));
		model.addAttribute("total",SalaryService.getcount(sp));
		model.addAttribute("salaryPayment", sp);
		return "salary/salary_list";
	}
	/**
	 * @Title: impExcel  
	 * @Description: 导入Excel薪资记录方法  
	 * @param sp
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	//@RequestParam详解:  https://blog.csdn.net/a350204530/article/details/60763379
	@RequestMapping("impexcel.do")
	public String impExcel(SalaryPayment sp,@RequestParam(value="file",required=false)MultipartFile file,Model model ,HttpServletRequest request){
		if (sp == null) {
			new SalaryPayment();
		}
		//上传地址
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

