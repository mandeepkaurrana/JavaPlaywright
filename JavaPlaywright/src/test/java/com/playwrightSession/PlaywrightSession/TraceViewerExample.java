package com.playwrightSession.PlaywrightSession;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TraceViewerExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	 Playwright playwright = Playwright.create();
	 
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

	BrowserContext context = browser.newContext();
	
	//Start tracing
	
	context.tracing().start(new Tracing.StartOptions().setScreenshots(true)
			.setSnapshots(true));
	
	Page page = context.newPage();
	
	page.navigate("http://www.amazon.in");
	 
	System.out.println("Title is :: " +page.title());
	
	
   Locator seachBox =	page.locator("#twotabsearchtextbox");
   
   seachBox.fill("Boat Headphones");
   
   
   page.locator("[type='submit']").press("Enter");
   
   Thread.sleep(100);
   
   
   
   
	 //Stop tracing
	 context.tracing().stop(new Tracing.StopOptions().
			 setPath(Paths.get("trace.zip")));
	 
	 page.close();
	 context.close();
	 playwright.close();
	 
	}

}
