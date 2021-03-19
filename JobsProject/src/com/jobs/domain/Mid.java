package com.jobs.domain;

import com.jobs.application.WrongSalaryException;

public class Mid extends Employee{
	
	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Mid(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone, salaryPerMonth, paymentRate);		
		if(salaryPerMonth<1800 || salaryPerMonth > 2500) throw new WrongSalaryException();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

}
