package com.playwrightSession.PlaywrightSession;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Emulations {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Playwright server creation and initialize
		 Playwright playwright = Playwright.create();
		 		 
		 //Broswer Type
		  BrowserType browserType = playwright.chromium();
		
		  //Browser
		  Browser  browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		  
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		int screenHeight = (int) screenSize.getHeight(); 
		int screenWidth = (int) screenSize.getWidth();
		  
		System.out.println(screenHeight +" : " +screenWidth);
		
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				  .setViewportSize(screenWidth, screenHeight));
	
		  
		Page page = context.newPage();
		
		page.navigate("https://www.amazon.in");
		
		Thread.sleep(3000);
		 page.close();
		 
		 
		 
	     context.close();
	     playwright.close();
	     
	     
		  
	}

}
