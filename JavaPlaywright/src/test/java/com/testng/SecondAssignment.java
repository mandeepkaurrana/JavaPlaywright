package com.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SecondAssignment {
	Browser browser;
	Page page_croma;
	Page page_flipkart;
	Page page_jiomart;
	BrowserContext brcntxt1;
	BrowserContext brcntxt2;
	BrowserContext brcntxt3;
	String price_croma;
	String price_flipkart;
	String price_jiomart;

	@BeforeTest
	public void run() {

		Playwright playwright = Playwright.create();
		{
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			brcntxt1 = browser.newContext(new Browser.NewContextOptions());
			brcntxt2 = browser.newContext(new Browser.NewContextOptions());
			brcntxt3 = browser.newContext(new Browser.NewContextOptions());
			// Page page = browser.newPage();
		}
	}

	@Test(priority = 1)
	public void croma() {

		page_croma = brcntxt1.newPage();
		page_croma.navigate("https://www.croma.com/");
		page_croma.fill("#searchV2", "iphone 12 128 gb");
		page_croma.keyboard().press("Enter");
		Locator c_price_locator = page_croma.locator("//span[@class='amount']").first();
		price_croma = c_price_locator.textContent();
		System.out.println(price_croma);

	}

	@Test(priority = 2)
	public void flipkart() {

		// Create a second page
		Page page_flipkart = brcntxt2.newPage();
		page_flipkart.navigate("https://www.flipkart.com");
		page_flipkart.click("button[class='_2KpZ6l _2doB4z']");
		page_flipkart.fill("//input[@name='q']", "iphone 12 128 gb");
		page_flipkart.click("//button[@type='submit']");

		Locator f_price_locator = page_flipkart.locator("//div[@class='_30jeq3 _1_WHN1']").first();
		price_flipkart = f_price_locator.textContent();
		System.out.println(price_flipkart);

	}

	@Test(priority = 3)

	public void jiomart() {

		// Create a third page
		Page page_jiomart = brcntxt3.newPage();
		page_jiomart.navigate("https://www.jiomart.com");
		page_jiomart.fill("#autocomplete-0-input", "iphone 12 128 gb");
		page_jiomart.keyboard().press("Enter");
		Locator j_price_locator = page_jiomart.locator("//span[@class='jm-heading-xxs jm-mb-xxs']").first();
		price_jiomart = j_price_locator.textContent();
		System.out.println(price_jiomart);
	
	}

	@Test(priority = 4)
	public void priceCompare() {

		Double priceCroma = getPrice(price_croma);
		Double priceFlipkart = getPrice(price_flipkart);
		Double priceJiomart = getPrice(price_jiomart);

		if (priceCroma <= priceFlipkart && priceCroma <= priceJiomart) {
			System.out.println("Minimum Price: " + priceCroma);
		} else if (priceFlipkart <= priceCroma && priceFlipkart <= priceJiomart) {
			System.out.println("Minimum Price: " + priceFlipkart);
		} else {
			System.out.println("Minimum Price: " + priceJiomart);
		}
	}

	public static Double getPrice(String price) {
		String priceNum = price.replaceAll("[^0-9.]", "");
		return Double.parseDouble(priceNum);
	}

	@AfterTest
	public void tear() {
		// Closing all the browser contexts
		brcntxt1.close();
		brcntxt2.close();
		brcntxt3.close();
	}

}
