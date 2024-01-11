package com.playwrightSession.PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

public class Locators {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.bigbasket.com/");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for Products..")).click();
      
     Locator seachbox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search for Products.."));
      assertThat(seachbox).isEmpty();
      seachbox.fill("Poha");
      page.getByRole(AriaRole.FORM).filter(new Locator.FilterOptions().setHasText("BB RoyalPoha/Avalakki - MediumBB RoyalPoha/Avalakki - Medium1 kgRs.58 Qty ADD Rs")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("BB Royal Poha/Avalakki - Medium")).click();
      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^ADD TO BASKET$"))).click();
      page.locator("._1aJzw").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Basmati Rice")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bigbasket").setExact(true)).click();
    }
  }
}
