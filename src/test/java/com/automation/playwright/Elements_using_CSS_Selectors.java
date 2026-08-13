package com.automation.playwright;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Elements_using_CSS_Selectors
{
	public static void main(String[] args)
	{
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=context.newPage();
		
		page.navigate("https://cronosedc.cronos.ws/Login");
		
		System.out.println("Page URL: "+page.url());
		System.out.println("Page Title: "+page.title());
		
//		identification of elements by using CSS Selector: Syntaxt: Tagname[AN='AV']
		page.locator("input[name=\"loginname\"]").fill("user.1");
		page.locator("button[aria-label=\"Next\"]").click();
		page.locator("input[name=\"password\"]").fill("123");
		page.locator("button[aria-label=\"Sign in\"]").click();
		
		
		
//		fill()  >> clears the field then fills the data at once.
//		type()  >> appends the data one by one.
		
		
		page.close();
		browser.close();
		playwright.close();
		
	}
}
