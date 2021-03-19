package com.jobs.domain;

import com.jobs.application.WrongSalaryException;

public class Boss extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Boss(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<8000) throw new WrongSalaryException();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

}
