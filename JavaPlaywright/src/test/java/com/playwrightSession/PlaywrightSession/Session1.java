package com.playwrightSession.PlaywrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session1 {

	public static void main(String[] args) {
		
		//Playwright server creation and initialize
		 Playwright playwright = Playwright.create();
		 		 
		 //Broswer Type
		  BrowserType browserType = playwright.firefox();
		
		  //Browser
		  Browser  browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
		  
		  //Create browser context
		 
		  BrowserContext context1 = browser.newContext();
		  
		 // BrowserContext context2 = browser.newContext();
		  
		  //Opening a new Tab
		  Page page1 = context1.newPage();
		  Page  page3 = context1.newPage();
		  //Page page2 = context2.newPage();
		  
		  //Navigating to website
		  page1.navigate("https://amazon.in");
		  //page2.navigate("http://flipkart.com");
		  page3.navigate("https://facebook.com");
		  
		  System.out.println("The title of page is " + page1.title());
		 
		  System.out.println("The title of page is " + page3.title());
		  
		  context1.close();
		  //context2.close();
		  playwright.close();
		  
	        }
	}


