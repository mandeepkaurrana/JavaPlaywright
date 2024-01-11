package com.playwrightSession.PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


public class Session2 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/");
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByPlaceholder("What needs to be done?").click();
      page.pause();
      page.getByPlaceholder("What needs to be done?").fill("Hello");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All")).click();
    }
  }
}
