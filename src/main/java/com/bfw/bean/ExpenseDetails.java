/**
 * Project Name:costone
 * File Name:ExpenseDetails.java
 * Package Name:com.bfw.bean
 * Date:2018��6��15������2:38:30
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;
/**
 * ClassName:ExpenseDetails <br/>
 * Function: ������ϸʵ����. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��15�� ����2:38:30 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ExpenseDetails {
		//������ϸ���
		private Integer expenseDetailsId;
		
		//������
		private Integer expenseId;
		
		//����
		private Integer costId;
		
		//����������
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

