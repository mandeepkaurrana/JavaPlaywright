package com.myPlaywriteScript;

import com.microsoft.playwright.Page;

import org.testng.asserts.SoftAssert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class SecondScript {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = browser.newPage();
		page.navigate("http://automationexercise.com");

		String ActualTitle = page.title();
		String ExpectedTitle = "Automation Exercise";
		System.out.println(ActualTitle);
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(ActualTitle, ExpectedTitle);
		page.click("text=Products");
		sf.assertAll();

		String ActualTitle2 = page.title();
		String ExpectedTitle2 = "Automation Exercise - All Products";
		System.out.println(ActualTitle2);
		SoftAssert sf2 = new SoftAssert();
		sf2.assertEquals(ActualTitle2, ExpectedTitle2);

		page.fill("#search_product", "Men Tshirt");
		Thread.sleep(5000);
		page.click("id=submit_search");
		page.waitForTimeout(5000);

		// Locator locator = page.getByText(ExpectedTitle2);
		page.getByText("Searched Products");
		System.out.println(page.getByText("Searched Products").textContent());
		String text = page.getByText("Searched Products").textContent();
		assertThat(text.contains("Searched Products"));

		context.close();
		playwright.close();

	}

	private static void assertThat(boolean contains) {
		// TODO Auto-generated method stub

	}
}
