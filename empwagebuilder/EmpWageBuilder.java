package com.empwagebuilder;

public class EmpWageBuilder {
		private static final int IS_FULL_TIME = 1;
		private static final int EMP_RATE_PER_HOUR = 20;
		
		public static void main(String[] args) {
			int empHrs = 0;
			int empWage = 0;
			double empCheck = Math.floor(Math.random() * 10) % 2;
			if (empCheck == IS_FULL_TIME)
				empHrs = 8;
			else
				empHrs = 0;
			empWage = empHrs * EMP_RATE_PER_HOUR;
			System.out.println("Emp Wage: " + empWage);
		}
}
