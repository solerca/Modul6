package com.jobs.domain;

import com.jobs.application.WrongSalaryException;

public class Senior extends Employee{
	
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Senior(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);		
		if(salaryPerMonth<2700 || salaryPerMonth > 4000) throw new WrongSalaryException();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaidBrut=paymentRate.pay(salaryPerMonth);
		totalPaidNet = totalPaidBrut - (totalPaidBrut * 0.24);
	}

}
