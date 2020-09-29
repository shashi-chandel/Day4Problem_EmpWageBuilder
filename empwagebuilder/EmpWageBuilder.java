package com.empwagebuilder;
 class CompanyEmpWage {
	
	private final String company;
	final int empRatePerHour;
	final int numOfWorkingDays;
	final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}
	
	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage=totalEmpWage;
	}
	@Override
	public String toString() {
		return "Total Employee Wage for Company '"+company+"' is: "+totalEmpWage;
	}
}

public class EmpWageBuilder{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	
	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	public EmpWageBuilder() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}
	
	private void addCompanyEmpWage (String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		numOfCompany++;
	}
	
	private void computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	
	private int computeEmpWage(CompanyEmpWage companyEmpwage) { 
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs  <= companyEmpwage.maxHoursPerMonth && totalWorkingDays < companyEmpwage.numOfWorkingDays) {
				totalWorkingDays++;
				int empCheck = (int) Math.floor(Math.random() * 10) % 3;
				switch (empCheck) 
				{
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
				}
			totalEmpHrs += empHrs;
			System.out.println("Day: " + totalWorkingDays + " Employee Hours: " +empHrs);
			}
		return totalEmpHrs * companyEmpwage.empRatePerHour;
	}
	
	public static void main(String[] args) {
		EmpWageBuilder empWagebuilder = new EmpWageBuilder();
		empWagebuilder.addCompanyEmpWage("DMart", 20, 2, 10);
		empWagebuilder.addCompanyEmpWage("Jio", 10, 4, 20);
		empWagebuilder.computeEmpWage();
	}
}
