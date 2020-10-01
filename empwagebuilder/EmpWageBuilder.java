package com.empwagebuilder;

import java.util.*;

public class EmpWageBuilder implements ICalculateEmpWage {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private int noOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageBuilder() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String company, int empRatePerHr, int noOfDays, int maxHrsPerMonth) {
		companyEmpWageArray[noOfCompany] = new CompanyEmpWage(company, empRatePerHr, noOfDays, maxHrsPerMonth);
		noOfCompany++;
	}

	public void computeEmpWage() {
		for (int i = 0; i < noOfCompany; i++) {
			companyEmpWageArray[i].setTotalWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}

	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs <= companyEmpWage.maxHrsPerMonth && totalWorkingDays < companyEmpWage.noOfDays) {
			totalWorkingDays++;
			int check = (int) Math.floor(Math.random() * 10) % 3;
			switch (check) {
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
			System.out.println("Days: " + totalWorkingDays + " EmpHours: " + empHrs);
		}
		return totalEmpHrs * companyEmpWage.empRatePerHr;
	}

	public static void main(String[] args) {
		ICalculateEmpWage empWageObj = new EmpWageBuilder();
		empWageObj.addCompanyEmpWage("DMart", 20, 2, 10);
		empWageObj.addCompanyEmpWage("Jio", 10, 4, 20);
		empWageObj.computeEmpWage();
	}

}
