/**
 * Project Name:costone
 * File Name:SalaryPaymentServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018年6月27日下午4:13:10
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.awt.print.Book;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.SalaryPayment;
import com.bfw.dao.ISalaryPaymentDAO;
import com.bfw.dao.IUserInfoDAO;
import com.bfw.service.ISalaryPaymentService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * ClassName:SalaryPaymentServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月27日 下午4:13:10 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class SalaryPaymentServiceImpl implements ISalaryPaymentService {
	//依赖注入
	@Autowired
	private ISalaryPaymentDAO salaryDAO;
	
	//@Autowired
	//private IUserInfoDAO UserInfo;
	
	/**
	 * TODO 薪资管理添加方法
	 * @see com.bfw.service.ISalaryPaymentService#add(com.bfw.bean.SalaryPayment)
	 */
	public void add(SalaryPayment sp) {
		//com.bfw.bean.UserInfo user=new com.bfw.bean.UserInfo();
		salaryDAO.add(sp);
		//UserInfo.list(user);

	}
	/**
	 * 
	 * TODO 薪资查询列表.
	 * @see com.bfw.service.ISalaryPaymentService#list(com.bfw.bean.SalaryPayment)
	 */
	public List<SalaryPayment> list(SalaryPayment sp) {
		//查询方法
		if(sp!=null){
			if (sp.getUserName()!=null && ! sp.getUserName().equals("")) {
				sp.setUserName("%"+sp.getUserName()+"%");
			}
		}
		return salaryDAO.list(sp);
	}
	/**
	 * 
	 * TODO 总记录数
	 * @see com.bfw.service.ISalaryPaymentService#getcount(com.bfw.bean.SalaryPayment)
	 */
	public long getcount(SalaryPayment sp) {
		if (sp!=null) {
			if (sp.getUserName()!=null && ! sp.getUserName().equals("")) {
				sp.setUserName("%"+sp.getUserName()+"%");
			}
		}
		
		return salaryDAO.getcount(sp);
	}
	/**
	 * 
	 * TODO 导入薪资记录
	 * @throws IOException 
	 * @throws BiffException 
	 * @see com.bfw.service.ISalaryPaymentService#BatchAdd(java.io.InputStream)
	 */
	public void BatchAdd(InputStream is) throws Exception {

		Workbook book = Workbook.getWorkbook(is);
		Sheet sheet = book.getSheet(0);
		System.out.println(sheet.getColumns());
		System.out.println(sheet.getRows());
		
		for(int i=1;i<sheet.getRows();i++){
			SalaryPayment sp = new SalaryPayment();
			
			//用户编号
			Cell idcell = sheet.getCell(0, i); 
			Integer userId = Integer.parseInt(idcell.getContents());
			sp.setUserId(userId);
			
			//发放时间
			Cell timecell = sheet.getCell(2, i); 
			String time = timecell.getContents();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date paymentTime = sdf.parse(time);
			sp.setPaymentTime(paymentTime);
			
			//发放金额
			Cell moneycell = sheet.getCell(3, i); 
			Double paymentMoney =  Double.parseDouble(moneycell.getContents());
			sp.setPaymentMoney(paymentMoney);
			salaryDAO.add(sp);
		
			
		}

	}
	
}

