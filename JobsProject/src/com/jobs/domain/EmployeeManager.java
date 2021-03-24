package com.jobs.domain;

import com.jobs.application.WrongSalaryException;

public class EmployeeManager extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public EmployeeManager(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<3000 || salaryPerMonth >5000) throw new WrongSalaryException();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaidBrut=paymentRate.pay(salaryPerMonth);
		totalPaidNet = totalPaidBrut - (totalPaidBrut * 0.26);
	}
	public void payBonus() {
		salaryPerMonth += salaryPerMonth*1.2;
	}

}
