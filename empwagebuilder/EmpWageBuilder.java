package com.empwagebuilder;

import java.util.*;

public class EmpWageBuilder implements ICalculateEmpWage {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	private Map<String, CompanyEmpWage> cMap;

	public EmpWageBuilder() {
		companyEmpWageArrayList = new ArrayList<>();
		cMap = new HashMap<>();
	}

	public void addCompanyEmpWage(String company, int empRatePerHr, int noOfDays, int maxHrsPerMonth) {
		CompanyEmpWage ce = new CompanyEmpWage(company, empRatePerHr, noOfDays, maxHrsPerMonth);
		companyEmpWageArrayList.add(ce);
		cMap.put(company, ce);
	}

	public void computeEmpWage() {
		for (int i = 0; i < companyEmpWageArrayList.size(); i++) {
			CompanyEmpWage ce = companyEmpWageArrayList.get(i);
			ce.setTotalWage(this.computeEmpWage(ce));
			System.out.println(ce);
		}
	}

	private int computeEmpWage(CompanyEmpWage ce) {
		int i = 0, empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs <= ce.maxHrsPerMonth && totalWorkingDays < ce.noOfDays) {
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
			ce.dailyEmpWage.add(empHrs * ce.empRatePerHr);
			totalEmpHrs += empHrs;
			System.out.println("Days: " + totalWorkingDays + " EmpHours: " + empHrs + " Daily wage " + ce.dailyEmpWage.get(i));
			i++;
		}
		return totalEmpHrs * ce.empRatePerHr;
	}

	@Override
	public int getTotalWage(String company) {
		return cMap.get(company).totalWage;
	}

	public static void main(String[] args) {
		ICalculateEmpWage empWageObj = new EmpWageBuilder();
		empWageObj.addCompanyEmpWage("DMart", 20, 2, 10);
		empWageObj.addCompanyEmpWage("Jio", 10, 4, 20);
		empWageObj.computeEmpWage();
		System.out.println("\nTotal wage for DMart company " + empWageObj.getTotalWage("DMart"));
		System.out.println("Total wage for Jio company " + empWageObj.getTotalWage("Jio"));
	}

}
