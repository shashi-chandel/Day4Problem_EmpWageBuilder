package com.empwagebuilder;

public interface ICalculateEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHr, int noOfDays, int maxHrsPerMonth);
	public void computeEmpWage();
}
