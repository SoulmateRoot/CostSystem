/**
 * Project Name:costone
 * File Name:ExpenseDetails.java
 * Package Name:com.bfw.bean
 * Date:2018年6月15日下午2:38:30
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;
/**
 * ClassName:ExpenseDetails <br/>
 * Function: 报销明细实体类. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月15日 下午2:38:30 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ExpenseDetails {
		//报销明细编号
		private Integer expenseDetailsId;
		
		//报销单
		private Integer expenseId;
		
		//费用
		private Integer costId;
		
		//报销具体金额
		private Double expenseDetailsAmount;

		public Integer getExpenseDetailsId() {
			return expenseDetailsId;
		}

		public void setExpenseDetailsId(Integer expenseDetailsId) {
			this.expenseDetailsId = expenseDetailsId;
		}

		public Integer getExpenseId() {
			return expenseId;
		}

		public void setExpenseId(Integer expenseId) {
			this.expenseId = expenseId;
		}

		public Integer getCostId() {
			return costId;
		}

		public void setCostId(Integer costId) {
			this.costId = costId;
		}

		public Double getExpenseDetailsAmount() {
			return expenseDetailsAmount;
		}

		public void setExpenseDetailsAmount(Double expenseDetailsAmount) {
			this.expenseDetailsAmount = expenseDetailsAmount;
		}

}

