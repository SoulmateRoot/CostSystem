/**
 * Project Name:costone
 * File Name:CostInfoServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018年6月12日下午10:57:32
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
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
 * Function: 费用管理业务逻辑实现类<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午10:57:32 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
//spring支持编程式事务管理和声明式事务管理两种方式。
//@Transactional详解
//https://www.cnblogs.com/yepei/p/4716112.html  
//https://blog.csdn.net/kinseygeek/article/details/54931710
//这里面有几点需要大家留意：
//A. 一个功能是否要事务，必须纳入设计、编码考虑。不能仅仅完成了基本功能就ok。
//B. 如果加了事务，必须做好开发环境测试（测试环境也尽量触发异常、测试回滚），确保事务生效。
//C. 以下列了事务使用过程的注意事项，请大家留意。
//1. 不要在接口上声明@Transactional ，而要在具体类的方法上使用 @Transactional 注解，否则注解可能无效。
//2.不要图省事，将@Transactional放置在类级的声明中，放在类声明，会使得所有方法都有事务。故@Transactional应该放在方法级别，不需要使用事务的方法，就不要放置事务，比如查询方法。否则对性能是有影响的。
//3.使用了@Transactional的方法，对同一个类里面的方法调用， @Transactional无效。比如有一个类Test，它的一个方法A，A再调用Test本类的方法B（不管B是否public还是private），但A没有声明注解事务，而B有。则外部调用A之后，B的事务是不会起作用的。（经常在这里出错）
//4.使用了@Transactional的方法，只能是public，@Transactional注解的方法都是被外部其他类调用才有效，故只能是public。道理和上面的有关联。故在 protected、private 或者 package-visible 的方法上使用 @Transactional 注解，它也不会报错，但事务无效。
//5.经过在ICORE-CLAIM中测试，效果如下：
//A.抛出受查异常XXXException，事务会回滚。
//B.抛出运行时异常NullPointerException，事务会回滚。
//C.Quartz中，execute直接调用加了@Transactional方法，可以回滚；间接调用，不会回滚。（即上文3点提到的）
//D.异步任务中，execute直接调用加了@Transactional方法，可以回滚；间接调用，不会回滚。（即上文3点提到的）
//E.在action中加上@Transactional，不会回滚。切记不要在action中加上事务。
//F.在service中加上@Transactional，如果是action直接调该方法，会回滚，如果是间接调，不会回滚。（即上文3提到的）
//G.在service中的private加上@Transactional，事务不会回滚。 
@Service
@Transactional
public class CostInfoServiceImpl implements ICostInfoService {
	
	//依赖注入
	@Autowired
	private ICostInfoDAO costdao;
	

	/**
	 * 
	 * TODO 添加费用信息
	 * @see com.bfw.service.ICostInfoService#add(com.bfw.bean.CostInfo)
	 */
	public void add(CostInfo info) {
		costdao.add(info);

	}
	
	/**
	 * TODO 查询费用列表.
	 * @see com.bfw.service.ICostInfoService#list(com.bfw.bean.CostInfo)
	 */
	@Transactional(readOnly=true)
	public List<CostInfo> list(CostInfo info) {
		condition(info);
		return costdao.list(info);
	}
	
	/**
	 * TODO 业务逻辑 获取总条数
	 * @see com.bfw.service.ICostInfoService#getcount(com.bfw.bean.CostInfo)
	 */
	public long getcount(CostInfo info) {
		condition(info);
		return costdao.getcount(info);
	}
	/**
	 * 
	 * TODO 加载费用信息修改页面 业务逻辑实现方法
	 * @see com.bfw.service.ICostInfoService#getinfo(com.bfw.bean.CostInfo)
	 */
	public CostInfo getinfo(CostInfo info) {
		
		return costdao.getinfo(info);
	}
	/**
	 * 
	 * TODO 修改费用信息 业务逻辑实现方法
	 * @see com.bfw.service.ICostInfoService#update(com.bfw.bean.CostInfo)
	 */
	public void update(CostInfo info) {
		costdao.update(info);
		
	}
	
	/**
	 * 
	 * TODO 费用删除业务逻辑实现类
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
	 * @Description:查询条件方法 
	 * @param info      
	 * @return void    
	 * @throws
	 */
	public void condition(CostInfo info){
		if(info!=null){
			//设置只查询有效数据
			info.setCostMark(Comm.MARK_YES);
			//费用名称不为空时，设置查询条件
			if(info.getCostName()!=null &&!info.getCostName().equals("")){
				info.setCostName("%"+info.getCostName()+"%");
			}
		}
	}

	
	

}

