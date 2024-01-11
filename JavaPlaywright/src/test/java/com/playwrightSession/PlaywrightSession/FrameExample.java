package com.playwrightSession.PlaywrightSession;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Playwright server creation and initialize
		 Playwright playwright = Playwright.create();
		 		 
		 //Broswer Type
		  BrowserType browserType = playwright.chromium();
		
		  //Browser
		  Browser  browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		  
		  //Create browser context		 
		  BrowserContext context1 = browser.newContext();
		  
		  Page page =   context1.newPage();
		  
		  //page.navigate("https://demo.playwright.dev/todomvc/");
	      page.navigate("https://selectorshub.com/xpath-practice-page/");
	      
	     Locator textArea = page.locator("#userName input#kils");
	     
	     textArea.fill("Anil Bhatt");
	     
	     Thread.sleep(5000);
	     
	     page.close();
	     context1.close();
	     playwright.close();
	      
	}

}
