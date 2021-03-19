package com.jobs.application;

public class WrongSalaryException extends Exception{

	public WrongSalaryException() {
		super("El salari no correspon a aquesta posició");
	}
}
