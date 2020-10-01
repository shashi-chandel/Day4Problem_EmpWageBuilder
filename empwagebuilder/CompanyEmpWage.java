package com.empwagebuilder;

import java.util.*;

public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHr;
	public final int noOfDays;
	public final int maxHrsPerMonth;
	public int totalWage;
	public List<Integer> dailyEmpWage;

	public CompanyEmpWage(String company, int empRatePerHr, int noOfDays, int maxHrsPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.noOfDays = noOfDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
		dailyEmpWage = new ArrayList<>();
	}

	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}

	@Override
	public String toString() {
		return "Total Employee Wage for Company " + company + " is " + totalWage;
	}
}
