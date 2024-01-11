package com.playwrightSession.PlaywrightSession;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Session4 {

	public static void main(String[] args) {
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
		  
		  page.navigate("https://demo.playwright.dev/todomvc/");
	      page.navigate("https://demo.playwright.dev/todomvc/#/");
	      Locator locator = page.getByPlaceholder("What needs to be done?");
	      
	      locator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("LocatorScreenshot.png")));
	      
	      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("FullPage.png")).setFullPage(true));
		  
	      page.close();
	      context1.close();
	      playwright.close();
	      
	}

}
