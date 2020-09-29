package com.empwagebuilder;

public class EmpWageBuilder {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmpWageBuilder (String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}
	
	public void computeEmpWage() {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs  <= maxHoursPerMonth  && totalWorkingDays < numOfWorkingDays) {
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
		totalEmpWage = totalEmpHrs * empRatePerHour;
	}
	
	@Override
	public String toString()  {
		return "Total Employee Wage for Company '" + company + "' is: "+ totalEmpWage;
	}
	public static void main(String[] args) {
		EmpWageBuilder dMart = new EmpWageBuilder("DMart", 20, 2, 10);
		EmpWageBuilder jio = new EmpWageBuilder("Jio", 10, 4, 20);
		dMart.computeEmpWage();
		System.out.println(dMart);
		jio.computeEmpWage();
		System.out.println(jio);
	}
}
