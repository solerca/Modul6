package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	public static String dni;
	
	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
		setDni(dni);		
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}
	public static void setDni(String d) {
		dni = d;
	}
	
	@Override
	public void pay() {
		totalPaidBrut=paymentRate.pay(salaryPerMonth);
	}
	public void payBonus() {
		salaryPerMonth += salaryPerMonth*1.2;
	}

}
