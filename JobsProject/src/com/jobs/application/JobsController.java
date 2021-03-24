package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.EmployeeManager;
import com.jobs.domain.Junior;
import com.jobs.domain.Mid;
import com.jobs.domain.Senior;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;

	public JobsController() {
		this.repository = new EmployeeRepository();

	}

	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Boss boss = new Boss(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	public void createEmployeeSenior(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee boss = new Senior(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateSenior());
		repository.addMember(boss);
	}

	public void createEmployeeMid(String name, String address, String phone, double salaryPerMonth) throws Exception {
		Employee boss = new Mid(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateMid());
		repository.addMember(boss);
	}

	public void createEmployeeJunior(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		Employee boss = new Junior(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateJunior());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth)
			throws Exception {
		EmployeeManager boss = new EmployeeManager(name, address, phone, salaryPerMonth,
				PaymentFactory.createPaymentRateManagerEmployee());
		repository.addMember(boss);

	}

	public void payAllEmployeers() {

		for (AbsStaffMember staffMember : repository.getAllMembers()) {
			if (!(staffMember instanceof Volunteer)) {
				staffMember.pay();
			}
			if (staffMember instanceof Volunteer) {
				((Volunteer) staffMember).rebreAjutGobernamental();
			}

		}

	}
	public void payBonusToAllEmployeers() {

		for (AbsStaffMember staffMember : repository.getAllMembers()) {
			if (!(staffMember instanceof Volunteer)) {
				staffMember.payBonus();
			}
		}

	}

	public String getAllEmployees() {
		String member = "";
		for (AbsStaffMember staffMember : repository.getAllMembers()) {
			if (!(staffMember instanceof Volunteer)) {
				member += "\n" + staffMember.getName() + ", " + staffMember.getAddress() + ", " + staffMember.getPhone()
						+ "\n" + "sou mensual brut: " + staffMember.getSalariMensualBrut() + ", sou mensual net: "
						+ staffMember.getSalariMensualNet() + ", sou anual brut: " + staffMember.getSalariAnualBrut()
						+ ", sou anual net: " + staffMember.getSalariAnualNet();
			}
			if (staffMember instanceof Volunteer) {
				member += "\n" + staffMember.getName() + ", " + staffMember.getAddress() + ", " + staffMember.getPhone()
						+ "\n" + "ajut gobernamental: " + ((Volunteer)staffMember).getAjutGobernamental();
			}
		}

		return member;
	}

	public void createVolunteer(String name, String adress, String phone) throws Exception {
		Volunteer voluntari = new Volunteer(name, adress, phone);
		repository.addMember(voluntari);
	}

}
