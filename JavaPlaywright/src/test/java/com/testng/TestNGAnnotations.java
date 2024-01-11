package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suit is executed");
	}

	@BeforeClass
	public void beforelass() {
		System.out.println("Before Class is executed");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test is executed");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method is executed");
	}

	@Test(priority = 1, groups = "Smoke")
	public void signIn() {
		System.out.println("A Smoke Test script with P1 test priority");
	}

	@Test(priority = 2, groups = "Regression")
	public void registeredUser() {
		System.out.println("A Regression Test script with P2 test priority");
	}
	
	@Test(enabled = false)
	public void purchase() {
		System.out.println("This Test case is in progress. So marking the enabled flag value as false. This Test script will be skippped for executions");
	}
	
	@Test
	public void purchase2() {
		System.out.println("This Test case is in progress. So marking the enabled flag value as false. This Test script will be skippped for executions");
	}
	
	@Test(enabled = false)
	public void purchase3() {
		System.out.println("This Test case is in progress. So marking the enabled flag value as false. This Test script will be skippped for executions");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class is executed");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test is executed");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method is executed");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suit is executed");

	}

}
