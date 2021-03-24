package com.jobs.domain;



public class Volunteer extends AbsStaffMember {
	

	protected double salaryPerMonth;
	protected double ajutGobernamental;

	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		
		//TODO
	}
	
	
	@Override
	public void pay() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}
	public void payBonus() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	public void rebreAjutGobernamental() {
		ajutGobernamental = 300;
	}
	public double getAjutGobernamental() {
		return ajutGobernamental;
	}

}
