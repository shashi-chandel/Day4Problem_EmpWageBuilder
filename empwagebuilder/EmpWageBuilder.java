package com.empwagebuilder;

import java.util.*;

public class EmpWageBuilder implements ICalculateEmpWage {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	private Map<String, CompanyEmpWage> cMap;

	public EmpWageBuilder() {
		companyEmpWageArrayList = new ArrayList<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHr, int noOfDays, int maxHrsPerMonth) {
		CompanyEmpWage ce = new CompanyEmpWage(company, empRatePerHr, noOfDays, maxHrsPerMonth);
		companyEmpWageArrayList.add(ce);
	}

	public void computeEmpWage() {
		for (int i = 0; i < companyEmpWageArrayList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
			companyEmpWage.setTotalWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}

	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int i = 0, empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
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
			companyEmpWage.dailyEmpWage.add(empHrs * companyEmpWage.empRatePerHr);
			totalEmpHrs += empHrs;
			System.out.println("Day: " + totalWorkingDays + " EmpHours " + empHrs + " Daily wage "
					+ companyEmpWage.dailyEmpWage.get(i));
			i++;
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
