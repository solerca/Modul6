package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaidBrut=0;
	protected double totalPaidNet=0;
	protected double salariAnualBrut=0;
	protected double salariAnualNet=0;
	
	
	
	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public double getSalariMensualBrut() {
		return totalPaidBrut;
	}
	public double getSalariMensualNet() {
		return totalPaidNet;
	}
	public double getSalariAnualBrut() {
		return totalPaidBrut *12;
	}
	public double getSalariAnualNet() {
		return totalPaidNet *12;
	}
	public abstract void pay() throws UnsupportedOperationException;

	public abstract void payBonus() throws UnsupportedOperationException;
}
