package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		this.repository = new EmployeeRepository();
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManagerEmployee());
		repository.addMember(boss);
		
	}


	public void payAllEmployeers() {
		List<AbsStaffMember> list = repository.getAllMembers();
		for (AbsStaffMember staffMember : repository.getAllMembers()) {
			staffMember.pay();
		}
		
		
	
	}

	public String getAllEmployees() {
		String member = "";
		for (AbsStaffMember staffMember : repository.getAllMembers()) {
			member += "\n" + staffMember.getName() + ", " + staffMember.getAddress() + ", " + staffMember.getPhone()  ;
		}
		
		return member;
	}

	public void createVolunteer(String name, String adress, String phone, String description) throws Exception {
		Volunteer voluntari = new Volunteer (name, adress, phone, description);
		repository.addMember(voluntari);
	}
	
	
	
}
