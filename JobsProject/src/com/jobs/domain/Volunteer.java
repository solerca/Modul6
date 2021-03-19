package com.jobs.domain;



public class Volunteer extends AbsStaffMember {
	

	protected double salaryPerMonth;


	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		
		//TODO
	}
	
	
	@Override
	public void pay() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}

}
