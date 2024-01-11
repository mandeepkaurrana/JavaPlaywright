package com.testng;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AssignmentTwo {
	
	
	public static void main(String [] args)
	{
	
	try (Playwright playwright = Playwright.create()) {
	
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	
	.setHeadless(false)
	
	.setSlowMo(100));
	
	BrowserContext context = browser.newContext(new Browser.NewContextOptions()
	
	.setHttpCredentials("admin", "admin"));
	
	Page page = context.newPage();
	
	page.navigate("https://the-internet.herokuapp.com/basic_auth");
	
	assertThat(page.locator("div[class='example'] p")).hasText("Congratulations! You must have the proper credentials.");
	
	System.out.println(page.title());
	//.hasText("Congratulations! You must have the proper credentials.")
	}
	
	
	}
}

